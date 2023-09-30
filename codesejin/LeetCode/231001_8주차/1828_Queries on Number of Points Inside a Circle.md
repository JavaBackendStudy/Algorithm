# [LeetCode] Queries on Number of Points Inside a Circle

## 문제 링크: https://leetcode.com/problems/queries-on-number-of-points-inside-a-circle/description/

## 문제 설명 : 

- 2D 평면의 점 좌표가 points어디에 있는지 배열이 제공됩니다 . 여러 점이 동일한 좌표를 가질 수 있습니다.points[i] = [xi, yi]ith
- 또한 반지름이 에 중심을 둔 원을 설명하는 queries배열 이 제공됩니다 .queries[j] = [xj, yj, rj](xj, yj)rj
- 각 쿼리에 대해 원 내부의queries[j] 점 수를 계산합니다 . 원의 경계에 있는 점은 내부로 간주됩니다 .jth
- 쿼리 에 대한 답변이 있는 배열 을 반환합니다 .answeranswer[j]jth

## 풀이 설명 :

1. queries의 배열을 순회하면서 윈의 중심 (cx, cy), 반지름(r)을 가져옵니다.
2. points배열을 순회하면서 각 포인트의 x,y좌표를 가져옵니다.
3. 피타고라스 정리를 사용하여 점과 원의 중심 사이의 거리를 계산합니다.
   4. 이부분은 잘 몰라서 블로그 [링크 참고](https://dundung.tistory.com/152)

```java
class Solution {
    public int[] countPoints(int[][] points, int[][] queries) {
        int[] answer = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int cx = queries[i][0];
            int cy = queries[i][1];
            int r = queries[i][2];

            int cnt = 0;
            for (int j = 0; j < points.length; j++) {
                int px = points[j][0];
                int py = points[j][1];

                // 점 (px, py)가 원 (cx, cy, r) 내부에 있는지 확인
                double distance = Math.pow(px - cx, 2) + Math.pow(py - cy, 2);
                if (distance <=  Math.pow(r,2)) {
                    cnt++;
                }
            }
            answer[i] = cnt;
        }

        return answer;
    }
}

```

```text
Runtime : 15 ms
Memory: 44 MB
```