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
        // 순서롤 뒤에서부터 뒤집으면 되는걸 줄 알았는데 그게 아닌가봄
        // 정확도 65.점
//        int answer = 0;
//        char[] chars = before.toCharArray();
//        String temp = "";
//        for (int i = chars.length-1; i >= 0 ; i--) {
//            temp += chars[i];
//        }
//        System.out.println("temp = " + temp);
//        if (temp.equals(after)) return 1;
//        return answer;

        char[] before2 = before.toCharArray();
        char[] after2 = after.toCharArray();
        Arrays.sort(before2);
        Arrays.sort(after2);

        String before3 = new String(before2);
        String after3 =  new String(after2);

        if (before3.equals(after3)) return 1;
        return answer;
    }
}
-----------------------------------------------------------
정확성  테스트
테스트 1 〉	통과 (0.36ms, 76.3MB)
테스트 2 〉	통과 (0.47ms, 85.6MB)
테스트 3 〉	통과 (0.35ms, 74.8MB)
테스트 4 〉	통과 (0.38ms, 67.5MB)
테스트 5 〉	통과 (0.72ms, 74.4MB)
테스트 6 〉	통과 (0.36ms, 76.8MB)
테스트 7 〉	통과 (0.34ms, 74.6MB)
테스트 8 〉	통과 (0.56ms, 75.6MB)
테스트 9 〉	통과 (0.35ms, 76.9MB)
테스트 10 〉	통과 (0.69ms, 77.1MB)
테스트 11 〉	통과 (0.62ms, 81.7MB)
테스트 12 〉	통과 (0.92ms, 69.8MB)
테스트 13 〉	통과 (0.52ms, 74.5MB)
테스트 14 〉	통과 (0.46ms, 76.2MB)
테스트 15 〉	통과 (0.42ms, 76.9MB)
테스트 16 〉	통과 (0.54ms, 74.6MB)
테스트 17 〉	통과 (0.51ms, 75.7MB)
테스트 18 〉	통과 (0.65ms, 80.9MB)
테스트 19 〉	통과 (0.62ms, 71.9MB)
테스트 20 〉	통과 (0.65ms, 73.9MB)
테스트 21 〉	통과 (0.98ms, 72.2MB)
테스트 22 〉	통과 (0.38ms, 86MB)
테스트 23 〉	통과 (0.33ms, 75.9MB)
```
