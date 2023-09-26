# [프로그래머스] qr code

---

## 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/181903

<br>

## 문제 설명:

- 두 정수 q, r과 문자열 code가 주어질 때, 
- code의 각 인덱스를 q로 나누었을 때 나머지가 r인 위치의 문자를 앞에서부터 순서대로 이어 붙인 문자열을 return 하는 solution 함수를 작성해 주세요.
---

## 풀이 설명

1. code의 문자열을 순회하면서 인덱스 값이 q로 나눴을때 나머지가 r과 같다면 해당 문자를 합쳐서 반환한다

```java
class Solution {
    public String solution(int q, int r, String code) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < code.length(); i++) {
            int remainder = i % q;
            if (remainder == r) {
                char c = code.charAt(i);
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
```

```text
테스트 1 〉	통과 (0.10ms, 78.3MB)
테스트 2 〉	통과 (0.07ms, 76.8MB)
테스트 3 〉	통과 (0.09ms, 71.9MB)
테스트 4 〉	통과 (0.05ms, 77.2MB)
테스트 5 〉	통과 (0.19ms, 74.7MB)
테스트 6 〉	통과 (0.03ms, 74MB)
테스트 7 〉	통과 (0.10ms, 80.6MB)
테스트 8 〉	통과 (0.11ms, 72.6MB)
테스트 9 〉	통과 (0.03ms, 74.6MB)
테스트 10 〉	통과 (0.05ms, 86.1MB)
테스트 11 〉	통과 (0.07ms, 75.9MB)
테스트 12 〉	통과 (0.05ms, 76.8MB)
테스트 13 〉	통과 (0.10ms, 80MB)
테스트 14 〉	통과 (0.10ms, 73.6MB)
테스트 15 〉	통과 (0.12ms, 76.5MB)
테스트 16 〉	통과 (0.10ms, 76.7MB)
테스트 17 〉	통과 (0.06ms, 89.4MB)
테스트 18 〉	통과 (0.09ms, 72.8MB)
테스트 19 〉	통과 (0.13ms, 83.7MB)
테스트 20 〉	통과 (0.06ms, 82.1MB)
```