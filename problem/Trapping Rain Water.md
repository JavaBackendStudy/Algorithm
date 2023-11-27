# [leetcode] 42. Trapping Rain Water

---

## 문제 링크:

[문제 바로가기](https://leetcode.com/problems/trapping-rain-water/)

## 문제 설명:

Given `n` non-negative integers representing an elevation map where the width of each bar is `1`, compute how much water it can trap after raining.

**Example 1:**

![https://assets.leetcode.com/uploads/2018/10/22/rainwatertrap.png](https://assets.leetcode.com/uploads/2018/10/22/rainwatertrap.png)

```
Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.

```

**Example 2:**

```
Input: height = [4,2,0,3,2,5]
Output: 9

```

**Constraints:**

- `n == height.length`
- `1 <= n <= 2 * 104`
- `0 <= height[i] <= 105`

## 문제 풀이:

```jsx
import java.util.*;
class Solution {
    public int trap(int[] height) {
        int ans = 0;
        Queue<Integer> queue = new LinkedList<>();
        Stack<Integer> st = new Stack<>();
        int maxpeek = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > height[maxpeek]) maxpeek = i;
        }
        for (int i = 0; i <= maxpeek; i++) {
            queue.add(height[i]);
        }
        for (int j = maxpeek; j < height.length; j++) {
            st.add(height[j]);
        }
        int leftpoint = Integer.MIN_VALUE;

        while (!queue.isEmpty()) {
            int currentHeight = queue.poll();
            if (queue.isEmpty() || currentHeight == maxpeek) break;

            leftpoint = Math.max(leftpoint, currentHeight);

            if (!queue.isEmpty() && leftpoint > queue.peek()) {
                ans += leftpoint - queue.peek();
            }
        }

        int rightpoint = Integer.MIN_VALUE;

        while (!st.isEmpty()) {
            int currentHeight = st.pop();
            if (st.isEmpty() || currentHeight == maxpeek) break;

            rightpoint = Math.max(rightpoint, currentHeight);

            if (!st.isEmpty() && rightpoint > st.peek()) {
                ans += rightpoint - st.peek();
            }
        }
        return ans;
    }
}
```