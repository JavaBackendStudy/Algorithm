# [프로그래머스] 무작위로 K개의 수 뽑기

---

## 문제 링크:

https://school.programmers.co.kr/learn/courses/30/lessons/181894

---

<br>

## 나의 문제 풀이:

```java
class Solution {

    public static void main(String[] args) {
        int[] arr = {0, 1, 1, 1, 1};
        int k = 4;

        System.out.println(Arrays.toString(solution(arr, k)));
    }

    public static int[] solution(int[] arr, int k) {
        List<Integer> result = Arrays.stream(arr)
                .distinct()
                .boxed()
                .limit(k)
                .collect(Collectors.toList());

        if (result.size() < k) {
            for (int i = result.size(); i < k; i++) {
                result.add(-1);
            }
        }

        return result.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
-----------------------------------------------------------
정확성  테스트
테스트 1 〉	통과 (8.10ms, 74.2MB)
테스트 2 〉	통과 (4.76ms, 79.6MB)
테스트 3 〉	통과 (6.00ms, 92.5MB)
테스트 4 〉	통과 (9.31ms, 77.7MB)
테스트 5 〉	통과 (6.36ms, 76.5MB)
테스트 6 〉	통과 (6.32ms, 79.9MB)
테스트 7 〉	통과 (5.79ms, 69.1MB)
테스트 8 〉	통과 (8.17ms, 71.8MB)
테스트 9 〉	통과 (6.05ms, 74.8MB)
테스트 10 〉	통과 (7.94ms, 87.9MB)
테스트 11 〉	통과 (7.27ms, 87.5MB)
테스트 12 〉	통과 (9.84ms, 85MB)
테스트 13 〉	통과 (6.48ms, 79.6MB)
테스트 14 〉	통과 (8.16ms, 91MB)
테스트 15 〉	통과 (8.72ms, 85.1MB)
테스트 16 〉	통과 (9.64ms, 99.4MB)
테스트 17 〉	통과 (9.99ms, 84.9MB)
테스트 18 〉	통과 (7.27ms, 78.9MB)
테스트 19 〉	통과 (7.72ms, 77.4MB)
테스트 20 〉	통과 (6.11ms, 78.9MB)
```
