# [프로그래머스] k의 개수

---

## 문제 링크:

https://school.programmers.co.kr/learn/courses/30/lessons/120887

<br>

## 문제 설명:

- 1부터 13까지의 수에서, 1은 1, 10, 11, 12, 13 이렇게 총 6번 등장합니다. 정수 i, j, k가 매개변수로 주어질 때, i부터 j까지 k가 몇 번 등장하는지 return 하도록 solution 함수를 완성해주세요.
- 참고 11은 1이 두번 나옴 그래서 6번 등장

---

<br>

## 문제 풀이:

```java
public class Solution {

    public static void main(String[] args) {
        int i = 10;
        int j = 50;
        int k = 5;

        System.out.println(solution(i, j, k));
    }

    public static int solution(int i, int j, int k) {
        int answer = 0;

        for (int l = i; l <= j; l++) {
            String s = String.valueOf(l);
            for (int i1 = 0; i1 < s.length(); i1++) {
                char c = s.charAt(i1);
                char temp = (char) (k + '0');
                if (c == temp) {
                    answer += 1;
                }
            }
        }
        return answer;
    }
}

-----------------------------------------------------------
정확성  테스트
테스트 1 〉	통과 (19.05ms, 82.5MB)
테스트 2 〉	통과 (0.02ms, 74.1MB)
테스트 3 〉	통과 (0.03ms, 69.4MB)
테스트 4 〉	통과 (4.53ms, 79.4MB)
테스트 5 〉	통과 (2.37ms, 74.8MB)
테스트 6 〉	통과 (0.04ms, 76.8MB)
테스트 7 〉	통과 (0.70ms, 78.4MB)
테스트 8 〉	통과 (11.77ms, 84.6MB)
```
---

### **문제 풀이 해석:**

- 반복문을 순회하면서 String 객체를 생성하여 String의 길이만큼 또 반복문을 순회함
- 이중 반복문 내부에서 char형으로 하나씩 바꿔가면서 k를 char형으로 형변환을 한뒤에 값을 검사
- String 객체 생성 및 형변환 하는데 오버헤드가 발생하니 그만큼 속도도 안나옴
---
