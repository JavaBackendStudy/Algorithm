# [LeetCode] Partition Array According to Given Pivot

## 문제 링크: https://leetcode.com/problems/partition-array-according-to-given-pivot/description/

## 문제 설명 :

- 주어진 것은 0으로 인덱싱된 정수 배열(nums)와 정수 pivot입니다. 배열(nums)를 재배열하여 다음 조건을 만족시켜야 합니다:

- Pivot보다 작은 모든 요소는 Pivot보다 큰 모든 요소 앞에 나와야 합니다.
- Pivot과 같은 요소는 Pivot보다 작은 요소와 큰 요소 사이에 위치해야 합니다.
- Pivot보다 작은 요소와 Pivot보다 큰 요소의 상대적인 순서는 유지되어야 합니다.
- 보다 형식적으로, 모든 pi, pj를 고려하십시오. 여기서 pi는 i번째 요소의 새 위치이고 pj는 j번째 요소의 새 위치입니다. 
- Pivot보다 작은 요소에 대해, i < j이고 nums[i] < pivot, nums[j] < pivot이라면, pi < pj여야 합니다. Pivot보다 큰 요소에 대해서도 동일한 조건이 적용됩니다.

- 재배치 후의 nums 배열을 반환하세요.


```java
class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int[] answer = new int[nums.length];
        List<Integer> before = new ArrayList<>();
        List<Integer> mid = new ArrayList<>();
        List<Integer> after = new ArrayList<>();
        for (int x : nums) {
            if (x < pivot) {
                before.add(x);
            } else if (x > pivot) {
                after.add(x);
            } else {
                mid.add(x);
            }
        }
        int midIdx = 0, afterIdx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i <= before.size() -1) {
                answer[i] = before.get(i);
            } else if (i > before.size()-1 && i <= before.size() + mid.size() - 1) {
                answer[i] = mid.get(midIdx++);
            } else if (i > before.size() + mid.size() - 1) {
                answer[i] = after.get(afterIdx++);
            }
        }
        return answer;
    }
}
```
```text
Runtime : 15 ms
Memory: 57.6 MB
```