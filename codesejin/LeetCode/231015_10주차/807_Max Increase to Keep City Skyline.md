# [LeetCode] Max Increase to Keep City Skyline

## 문제 링크: https://leetcode.com/problems/max-increase-to-keep-city-skyline/

## 문제 설명 :

- 주어진 입력에는 n x n 블록으로 이루어진 도시가 있습니다.
- 각 블록에는 수직으로 정사각형 기둥 형태의 건물이 하나씩 들어 있습니다.
- 0으로 인덱싱된 n x n 정수 행렬 grid가 주어지며, grid[r][c]는 행 r와 열 c에 위치한 블록의 건물 높이를 나타냅니다.

- 도시의 경계선은 도시를 멀리서 바라볼 때 도시의 측면을 이루는 모든 건물에 의해 형성되는 외곽 윤곽을 나타냅니다.
- 도시의 각 기본 방향(북, 동, 남, 서)에서 바라본 스카이라인은 다를 수 있습니다.

- 우리의 목표는 어떤 건물의 높이를 얼마든지 늘릴 수 있습니다(건물마다 다를 수 있음).
- 0 높이의 건물의 높이도 늘릴 수 있습니다. 그러나 건물의 높이를 늘릴 때 어떤 기본 방향에서도 도시의 스카이라인이 변경되지 않아야 합니다.

- 어떤 기본 방향에서도 스카이라인이 변경되지 않는 한에서 건물 높이를 최대로 늘릴 수 있는 총 합을 반환해야 합니다.

## 풀이 설명 :

1. 좌측/우측에서 봤을때 스카이라인의 최대값, 행의 값이 똑같고( 8 7 9 3 ), 아래/위에서봤을때 열의 값이 똑같다( 9 4 8 7 )
2. 2중 포문을 이용해서 기존의 값보다 구해진 최대값까지 구해진 수 있는 최솟값을 찾아서 더해준다.

```java
class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int n = grid.length;
        int [] rowMax = new int[n];
        int [] colMax = new int[n];

        for(int i=0;i<n;i++){
            rowMax[i]=grid[i][0];
            colMax[i]=grid[0][i];
            for(int j=0; j<n; j++){
                rowMax[i]=Math.max(rowMax[i], grid[i][j]); 
                colMax[i]= Math.max(colMax[i], grid[j][i]);
            }
        }

        int sum=0;
        for(int i=0;i<n;i++){
            for(int j=0; j<n; j++){
                sum+=Math.min(rowMax[i], colMax[j])-grid[i][j];
            }
        }
        return sum;
    }
}
```


```text
Runtime : 2 ms
Memory: 44.1 MB
```