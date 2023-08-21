# 문제 링크
https://school.programmers.co.kr/learn/courses/30/lessons/120842

## 내풀이
```
테스트 1 〉	통과 (0.04ms, 73.6MB)
테스트 2 〉	통과 (0.02ms, 73.9MB)
테스트 3 〉	통과 (0.03ms, 76.3MB)
테스트 4 〉	통과 (0.03ms, 73.8MB)
테스트 5 〉	통과 (0.01ms, 76.2MB)
테스트 6 〉	통과 (0.02ms, 84.1MB)
테스트 7 〉	통과 (0.02ms, 72.7MB)
```

## 다른 풀이
```java
class Solution {
    public int[][] solution(int[] num_list, int n) {
        int[][] answer = new int[num_list.length/n][n];
        int cnt = 0;
        for(int i = 0 ; i < num_list.length/n ; i++){
            for(int j = 0 ; j < n ; j++){
                answer[i][j] = num_list[cnt];
                cnt++;
            }
        }
        return answer;
    }
}
---------------------------
테스트 1 〉	통과 (0.03ms, 76.2MB)
테스트 2 〉	통과 (0.04ms, 73.1MB)
테스트 3 〉	통과 (0.03ms, 69.6MB)
테스트 4 〉	통과 (0.03ms, 80.9MB)
테스트 5 〉	통과 (0.02ms, 73.8MB)
테스트 6 〉	통과 (0.01ms, 75.4MB)
테스트 7 〉	통과 (0.02ms, 76.7MB)
```
## 나의 기존 풀이와 다른점
불필요한 배열 arr 을 제거
