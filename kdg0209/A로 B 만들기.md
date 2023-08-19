# [프로그래머스] A로 B 만들기

---

## 문제 링크:

https://school.programmers.co.kr/learn/courses/30/lessons/120886

<br>

## 문제 설명:

- 문자열 before와 after가 매개변수로 주어질 때, before의 순서를 바꾸어 after를 만들 수 있으면 1을, 만들 수 없으면 0을 return 하도록 solution 함수를 완성해보세요.

---

<br>

## 나의 문제 풀이:

```java
class Solution {
    
    public int solution(String before, String after) {
        char[] beforeArr = before.toCharArray();
		    char[] afterArr = after.toCharArray();

		    Arrays.sort(beforeArr);
		    Arrays.sort(afterArr);

		    String beforeStr = new String(beforeArr);
		    String afterStr = new String(afterArr);
		
		    if (beforeStr.equals(afterStr)) return 1;
		    return 0;
    }
}
-----------------------------------------------------------
정확성  테스트
테스트 1 〉	통과 (0.35ms, 72MB)
테스트 2 〉	통과 (0.45ms, 76.2MB)
테스트 3 〉	통과 (0.73ms, 84.8MB)
테스트 4 〉	통과 (0.38ms, 74.6MB)
테스트 5 〉	통과 (0.72ms, 82.4MB)
테스트 6 〉	통과 (0.61ms, 74MB)
테스트 7 〉	통과 (0.35ms, 82MB)
테스트 8 〉	통과 (0.50ms, 72.1MB)
테스트 9 〉	통과 (0.46ms, 74.1MB)
테스트 10 〉	통과 (0.47ms, 67.8MB)
테스트 11 〉	통과 (0.92ms, 72.9MB)
테스트 12 〉	통과 (1.01ms, 71.6MB)
테스트 13 〉	통과 (0.37ms, 69.5MB)
테스트 14 〉	통과 (0.50ms, 79MB)
테스트 15 〉	통과 (0.65ms, 77.7MB)
테스트 16 〉	통과 (0.72ms, 77.5MB)
테스트 17 〉	통과 (0.85ms, 79MB)
테스트 18 〉	통과 (1.00ms, 78.8MB)
테스트 19 〉	통과 (1.46ms, 71.7MB)
테스트 20 〉	통과 (1.08ms, 78.3MB)
테스트 21 〉	통과 (0.85ms, 70.8MB)
테스트 22 〉	통과 (0.35ms, 72.3MB)
테스트 23 〉	통과 (0.52ms, 78.8MB)
```
