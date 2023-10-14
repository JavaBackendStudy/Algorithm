# [프로그래머스] JadenCase문자열 만들기

## 문제 링크:https://school.programmers.co.kr/learn/courses/30/lessons/12951#

<br/>

## 문제 설명:

- JadenCase란 모든 단어의 첫 문자가 대문자이고, 그 외의 알파벳은 소문자인 문자열입니다. 
- 단, 첫 문자가 알파벳이 아닐 때에는 이어지는 알파벳은 소문자로 쓰면 됩니다. (첫 번째 입출력 예 참고)
- 문자열 s가 주어졌을 때, s를 JadenCase로 바꾼 문자열을 리턴하는 함수, solution을 완성해주세요.
---

## 풀이 설명

1. 간단하게 풀 수 있을 줄 알았는데, '공백문자가 연속해서 나올 수 있습니다' 때문에 분기처리가 좀 많아짐
2. 입력 문자열을 전부 소문자로 변환후 charArray로 타입변환
3. 0번째가 숫자일경우 대문자로 변경 분기처리
4. 공백이 마지막에 있을 경우 ArrayIndexOutOfBoundsException를 피하기 위해 break;하는 분기처리
5. 공백뒤에 알파벳이 있을 경우 대문자로 변경 분기처리 
2. 가독성이 떨어지는것같음..(?)


```java
class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        char[] charArray = s.toLowerCase().toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (i == 0 && Character.isAlphabetic(charArray[i])) charArray[i] = Character.toUpperCase(charArray[i]);
            else if(charArray[i] == ' ' && i == charArray.length-1) break;
            else if (charArray[i] == ' ' && Character.isAlphabetic(charArray[i+1])) charArray[i + 1] = Character.toUpperCase(charArray[i + 1]);
        }

        for (char x : charArray) {
            sb.append(x);
        }
        return sb.toString();
    }
}
```
```text
테스트 1 〉	통과 (0.08ms, 75.4MB)
테스트 2 〉	통과 (0.10ms, 70.9MB)
테스트 3 〉	통과 (0.06ms, 71.7MB)
테스트 4 〉	통과 (0.10ms, 75.7MB)
테스트 5 〉	통과 (0.11ms, 79.7MB)
테스트 6 〉	통과 (0.09ms, 74.9MB)
테스트 7 〉	통과 (0.11ms, 83MB)
테스트 8 〉	통과 (0.07ms, 72.9MB)
테스트 9 〉	통과 (0.07ms, 72.1MB)
테스트 10 〉	통과 (0.10ms, 74.3MB)
테스트 11 〉	통과 (0.09ms, 75.9MB)
테스트 12 〉	통과 (0.10ms, 83.4MB)
테스트 13 〉	통과 (0.07ms, 74MB)
테스트 14 〉	통과 (0.10ms, 69.6MB)
테스트 15 〉	통과 (0.14ms, 78.8MB)
테스트 16 〉	통과 (0.06ms, 77MB)
테스트 17 〉	통과 (0.10ms, 77.1MB)
테스트 18 〉	통과 (0.08ms, 73.3MB)
```