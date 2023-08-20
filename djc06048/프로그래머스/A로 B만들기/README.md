## 문제링크
https://school.programmers.co.kr/learn/courses/30/lessons/120886?language=java

## 내풀이
```
테스트 1 〉	통과 (0.21ms, 77.4MB)
테스트 2 〉	통과 (0.18ms, 73.2MB)
테스트 3 〉	통과 (0.23ms, 74.7MB)
테스트 4 〉	통과 (0.19ms, 72MB)
테스트 5 〉	통과 (10.06ms, 81.6MB)
테스트 6 〉	통과 (0.20ms, 74MB)
테스트 7 〉	통과 (0.17ms, 74.6MB)
테스트 8 〉	통과 (4.27ms, 70MB)
테스트 9 〉	통과 (0.14ms, 70.3MB)
테스트 10 〉	통과 (2.25ms, 72.7MB)
테스트 11 〉	통과 (15.29ms, 78.8MB)
테스트 12 〉	통과 (10.41ms, 80.1MB)
테스트 13 〉	통과 (0.19ms, 76.5MB)
테스트 14 〉	통과 (0.23ms, 77.5MB)
테스트 15 〉	통과 (2.85ms, 78.3MB)
테스트 16 〉	통과 (4.68ms, 79.1MB)
테스트 17 〉	통과 (3.97ms, 72.6MB)
테스트 18 〉	통과 (12.16ms, 75.1MB)
테스트 19 〉	통과 (10.36ms, 75.5MB)
테스트 20 〉	통과 (15.91ms, 81.8MB)
테스트 21 〉	통과 (11.76ms, 72.9MB)
테스트 22 〉	통과 (0.19ms, 74.1MB)
테스트 23 〉	통과 (0.14ms, 79.1MB)
```

## 다른사람풀이
```java
import java.util.Arrays;
class Solution {
    public int solution(String before, String after) {
      char[] beforeArr=before.toCharArray();
      char[] afterArr=after.toCharArray();
        
      Arrays.sort(beforeArr);
      Arrays.sort(afterArr);
       
     for(int i=0;i<beforeArr.length;i++){
         if(beforeArr[i]!=afterArr[i]) return 0;
     }
        return 1;
 
    }
}
-----------------------------------
테스트 1 〉	통과 (0.42ms, 69.1MB)
테스트 2 〉	통과 (0.50ms, 87.4MB)
테스트 3 〉	통과 (0.36ms, 80.5MB)
테스트 4 〉	통과 (0.38ms, 71.6MB)
테스트 5 〉	통과 (0.70ms, 71.1MB)
테스트 6 〉	통과 (0.50ms, 65.4MB)
테스트 7 〉	통과 (0.44ms, 71.2MB)
테스트 8 〉	통과 (0.84ms, 81.2MB)
테스트 9 〉	통과 (0.51ms, 75MB)
테스트 10 〉	통과 (0.46ms, 77.2MB)
테스트 11 〉	통과 (0.62ms, 77.2MB)
테스트 12 〉	통과 (0.70ms, 73.7MB)
테스트 13 〉	통과 (0.33ms, 72.8MB)
테스트 14 〉	통과 (0.53ms, 72.3MB)
테스트 15 〉	통과 (0.46ms, 67.5MB)
테스트 16 〉	통과 (0.51ms, 75.8MB)
테스트 17 〉	통과 (0.80ms, 76.3MB)
테스트 18 〉	통과 (0.71ms, 74.3MB)
테스트 19 〉	통과 (0.79ms, 76.1MB)
테스트 20 〉	통과 (0.67ms, 74.9MB)
테스트 21 〉	통과 (1.09ms, 85.5MB)
테스트 22 〉	통과 (0.35ms, 72.6MB)
테스트 23 〉	통과 (0.38ms, 76.3MB)
```

## 느낀점
순서를 바꾸어 만들수 있는 조합이면 1을 출력하는 것이기에
기존 스트링을 한글자씩 쪼개서 배열을 만들었다. 그 후 방문배열을 만들어 한번도 방문하지 못한 배열이면 0을 리턴하였다.

```toCharArray()```라는 메서드를 통해 char 배열로 변환한뒤 정렬 후 단순히 원소 비교하는 편이 더 좋다
