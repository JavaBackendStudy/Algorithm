# [LeetCode] Widest Vertical Area Between Two Points Containing No Points

## 문제 링크: https://leetcode.com/problems/widest-vertical-area-between-two-points-containing-no-points/

## 문제 설명 :

- 주어진 2D 평면 상에 n개의 점이 있습니다. 각 점은 [xi, yi] 형태로 주어집니다. 
- 어떤 두 점을 선택하여 그 사이에 수직으로 일정한 너비를 가지는 영역을 만들 때, 이 영역 안에 다른 점이 들어가지 않는 가장 넓은 수직 영역을 찾아야 합니다.
- 이 수직 영역은 무한히 높은 (즉, y축 방향으로 무한한 높이를 가진) 영역입니다. 가장 넓은 수직 영역은 최대 너비를 가지는 것을 의미합니다.
- 또한, 수직 영역의 가장자리에 위치한 점은 해당 영역 내에 포함되지 않습니다.
- 즉, 주어진 점들 중 어떤 두 점을 선택하여 그 사이에 수직으로 일정한 너비를 가지는 영역을 만들고, 이 영역 안에 다른 점이 없도록 하는 가장 넓은 영역을 찾아야 합니다.

## 풀이 설명

1. 예시 그림 처럼 너비의 최대를 구하려면 x값으로 처리해야하므로 arr에 x값을 넣어서 오름차순 정렬
2. 다음 x값과 현재 x값 사이의 max를 구하는 for문을 만든다

```java
class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        int arr[]=new int[points.length];
        for(int i=0;i<points.length;i++){
            arr[i]=points[i][0];
        }

        Arrays.sort(arr);
        int max =0;
        for(int i=0;i<points.length-1;i++){
            if(arr[i+1]-arr[i]>max){
                max=arr[i+1]-arr[i];
            }
        }
        return max;
    }
}

```
```text
Runtime : 13 ms
Memory: 68.1 MB
```