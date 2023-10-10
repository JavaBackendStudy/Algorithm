# [LeetCode] Left and Right Sum Differences

## 문제 링크: https://leetcode.com/problems/left-and-right-sum-differences/description/

## 문제 설명 :

Given a 0-indexed integer array nums, find a 0-indexed integer array answer where:

answer.length == nums.length.
answer[i] = |leftSum[i] - rightSum[i]|.
Where:

leftSum[i] is the sum of elements to the left of the index i in the array nums. If there is no such element, leftSum[i] = 0.
rightSum[i] is the sum of elements to the right of the index i in the array nums. If there is no such element, rightSum[i] = 0.
Return the array answer.



## 풀이 설명 :

1. 왼쪽 합계 계산 / 오른쪽 합계 계산
2. 마지막 반복문 돌리면서 left에서 right뺀 절대값 넣기
```java
class Solution {
    public int[] leftRightDifference(int[] nums) {

        int[] leftSum = new int[nums.length];
        int[] rightSum = new int[nums.length];
        // 왼쪽 합계 계산
        leftSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            leftSum[i] = leftSum[i - 1] + nums[i];
        }

        // 오른쪽 합계 계산
        rightSum[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            rightSum[i] = rightSum[i + 1] + nums[i];
        }

        // 결과 배열 계산
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = Math.abs(leftSum[i] - rightSum[i]);
        }

        return result;
    }
}
```

```text
Runtime : 2 ms
Memory: 43.46 MB
```