# [프로그래머스] JadenCase 문자열 만들기

---

## 문제 링크:

https://school.programmers.co.kr/learn/courses/30/lessons/12951

<br>

## 문제 설명:

- s는 길이 1 이상 200 이하인 문자열입니다.
    - s는 알파벳과 숫자, 공백문자(" ")로 이루어져 있습니다.
    - 숫자는 단어의 첫 문자로만 나옵니다.
    - 숫자로만 이루어진 단어는 없습니다.
    - 공백문자가 연속해서 나올 수 있습니다.

---

<br>

## 나의 문제 풀이:

```java
class Solution {

    public static void main(String[] args) {
        String s = "3people   unFollowed me";

        System.out.println(solution(s));
    }

    public static String solution(String s) {
        StringBuilder sb = new StringBuilder();

        sb.append(Character.toUpperCase(s.charAt(0)));
        for (int i = 1; i < s.length(); i++) {
            boolean isEmpty = s.charAt(i) == ' ';
            if (!isEmpty) {
                if (sb.charAt(i - 1) == ' ') {
                    sb.append(Character.toUpperCase(s.charAt(i)));
                } else {
                    sb.append(Character.toLowerCase(s.charAt(i)));
                }
            }
            if (isEmpty) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }
}
-----------------------------------------------------------
정확성  테스트
테스트 1 〉	통과 (0.06ms, 78MB)
테스트 2 〉	통과 (0.07ms, 75.8MB)
테스트 3 〉	통과 (0.06ms, 74.9MB)
테스트 4 〉	통과 (0.09ms, 69.7MB)
테스트 5 〉	통과 (0.09ms, 71.9MB)
테스트 6 〉	통과 (0.08ms, 75.2MB)
테스트 7 〉	통과 (0.07ms, 74.6MB)
테스트 8 〉	통과 (0.05ms, 74.1MB)
테스트 9 〉	통과 (0.07ms, 70.9MB)
테스트 10 〉	통과 (0.06ms, 76.5MB)
테스트 11 〉	통과 (0.09ms, 72.6MB)
테스트 12 〉	통과 (0.06ms, 77MB)
테스트 13 〉	통과 (0.13ms, 68.8MB)
테스트 14 〉	통과 (0.08ms, 79.3MB)
테스트 15 〉	통과 (0.13ms, 72.9MB)
테스트 16 〉	통과 (0.06ms, 78.3MB)
테스트 17 〉	통과 (0.07ms, 73.9MB)
테스트 18 〉	통과 (0.07ms, 74.2MB)
```
