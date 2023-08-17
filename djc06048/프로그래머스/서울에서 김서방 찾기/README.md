# 문제링크
https://school.programmers.co.kr/learn/courses/30/lessons/12919

## 내풀이
```
테스트 1 〉	통과 (0.24ms, 79.3MB)
테스트 2 〉	통과 (0.27ms, 73.7MB)
테스트 3 〉	통과 (0.22ms, 74.9MB)
테스트 4 〉	통과 (0.34ms, 75.5MB)
테스트 5 〉	통과 (0.26ms, 74.7MB)
테스트 6 〉	통과 (0.22ms, 70.4MB)
테스트 7 〉	통과 (0.24ms, 65.7MB)
테스트 8 〉	통과 (0.22ms, 74.7MB)
테스트 9 〉	통과 (0.27ms, 78.4MB)
테스트 10 〉	통과 (0.25ms, 76MB)
테스트 11 〉	통과 (0.30ms, 73.4MB)
테스트 12 〉	통과 (0.25ms, 76.6MB)
테스트 13 〉	통과 (0.24ms, 70.1MB)
테스트 14 〉	통과 (0.36ms, 68.5MB)
```
## 다른사람풀이
```java
import java.util.Arrays;
class Solution {
    public String solution(String[] seoul) {
        int loc=Arrays.asList(seoul).indexOf("Kim");
        
        return "김서방은 "+ loc + "에 있다";
    }
}
----------------------------
테스트 1 〉	통과 (5.64ms, 86.5MB)
테스트 2 〉	통과 (5.96ms, 78.8MB)
테스트 3 〉	통과 (6.76ms, 87.4MB)
테스트 4 〉	통과 (5.46ms, 77.2MB)
테스트 5 〉	통과 (6.25ms, 75MB)
테스트 6 〉	통과 (7.58ms, 73.7MB)
테스트 7 〉	통과 (7.17ms, 68.6MB)
테스트 8 〉	통과 (6.51ms, 78MB)
테스트 9 〉	통과 (7.21ms, 77.2MB)
테스트 10 〉	통과 (6.49ms, 71.5MB)
테스트 11 〉	통과 (6.31ms, 78.4MB)
테스트 12 〉	통과 (5.90ms, 74.1MB)
테스트 13 〉	통과 (6.62ms, 77.4MB)
테스트 14 〉	통과 (8.78ms, 82.2MB)
```
## 느낀점
자바 배열에서 특정 값의 인덱스를 구하려면 asList()를 활용해 ArrayList로 변환시켜야한다
역시 스트링 연산은 StringBuilder 를 사용하자
