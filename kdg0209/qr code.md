# [프로그래머스] qr code

---

## 문제 링크:

https://school.programmers.co.kr/learn/courses/30/lessons/181903

<br>

## 문제 설명:

- 두 정수 q, r과 문자열 code가 주어질 때, code의 각 인덱스를 q로 나누었을 때 나머지가 r인 위치의 문자를 앞에서부터 순서대로 이어 붙인 문자열을 return 하는 solution 함수를 작성해 주세요.

---

<br>

## 나의 문제 풀이:

```java
public class Solution {

    public static void main(String[] args) {
        int q = 3;
        int r = 1;
        String code = "qjnwezgrpirldywt";

        System.out.println(solution(q, r, code));
    }

    public static String solution(int q, int r, String code) {
        String[] split = code.split("");
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < split.length; i++) {
            if ((i % q) == r) {
                sb.append(split[i]);
            }
        }

        return sb.toString();
    }
}
-----------------------------------------------------------
정확성  테스트
테스트 1 〉	통과 (1.64ms, 78.2MB)
테스트 2 〉	통과 (1.21ms, 77.7MB)
테스트 3 〉	통과 (1.54ms, 76.5MB)
테스트 4 〉	통과 (0.51ms, 77.8MB)
테스트 5 〉	통과 (2.66ms, 74.9MB)
테스트 6 〉	통과 (0.16ms, 75.9MB)
테스트 7 〉	통과 (1.68ms, 65.9MB)
테스트 8 〉	통과 (1.34ms, 69MB)
테스트 9 〉	통과 (0.54ms, 72.1MB)
테스트 10 〉	통과 (0.40ms, 74.2MB)
테스트 11 〉	통과 (1.05ms, 80.2MB)
테스트 12 〉	통과 (0.49ms, 74.9MB)
테스트 13 〉	통과 (1.30ms, 79MB)
테스트 14 〉	통과 (1.37ms, 75.3MB)
테스트 15 〉	통과 (1.35ms, 73.4MB)
테스트 16 〉	통과 (1.66ms, 76MB)
테스트 17 〉	통과 (1.52ms, 90.3MB)
테스트 18 〉	통과 (1.54ms, 77.5MB)
테스트 19 〉	통과 (1.64ms, 73.9MB)
테스트 20 〉	통과 (1.24ms, 78.3MB)
```
