# [프로그래머스] 무작위로 k의 수 뽑기

## 문제 링크:https://school.programmers.co.kr/learn/courses/30/lessons/181858

<br/>

## 문제 설명:

- 랜덤으로 서로 다른 k개의 수를 저장한 배열을 만드려고 합니다. 적절한 방법이 떠오르지 않기 때문에 일정한 범위 내에서 무작위로 수를 뽑은 후,
- 지금까지 나온적이 없는 수이면 배열 맨 뒤에 추가하는 방식으로 만들기로 합니다.

- 이미 어떤 수가 무작위로 주어질지 알고 있다고 가정하고, 실제 만들어질 길이 k의 배열을 예상해봅시다.

- 정수 배열 arr가 주어집니다. 문제에서의 무작위의 수는 arr에 저장된 순서대로 주어질 예정이라고 했을 때, 완성될 배열을 return 하는 solution 함수를 완성해 주세요.

- 단, 완성될 배열의 길이가 k보다 작으면 나머지 값을 전부 -1로 채워서 return 합니다.
---

## 풀이 설명

1. 맨 처음에는 set으로 해서 제출했는데 실패나옴, '지금까지 나온적이 없는 수이면 배열 맨 뒤에 추가하는 방식'이라는 순서가 존재해서 그런것 같아서 list로 변경
2. Arrays.fill()메소드를 통해 -1로 초기화
3. k랑 사이즈 같으면 반복문 멈추고, list에 없는경우 추가


```java
import java.util.*;
class Solution {
    public int[] solution(int[] arr, int k) {
        int[] answer = new int[k];
        Arrays.fill(answer, -1);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (list.size() >= k) break;
            if (!list.contains(arr[i])) list.add(arr[i]);
        }
        int idx = 0;
        for (int x : list) {
            answer[idx++] = x;
        }
        return answer;
    }
}
```
```text
테스트 1 〉	통과 (0.07ms, 81.2MB)
테스트 2 〉	통과 (0.07ms, 79.6MB)
테스트 3 〉	통과 (0.08ms, 85.1MB)
테스트 4 〉	통과 (0.14ms, 74.2MB)
테스트 5 〉	통과 (0.15ms, 65.8MB)
테스트 6 〉	통과 (0.11ms, 76.8MB)
테스트 7 〉	통과 (1.63ms, 81.9MB)
테스트 8 〉	통과 (2.27ms, 79.7MB)
테스트 9 〉	통과 (1.26ms, 82.7MB)
테스트 10 〉	통과 (10.86ms, 82.1MB)
테스트 11 〉	통과 (9.87ms, 79.4MB)
테스트 12 〉	통과 (9.02ms, 78.1MB)
테스트 13 〉	통과 (3.97ms, 74.9MB)
테스트 14 〉	통과 (7.28ms, 78.4MB)
테스트 15 〉	통과 (4.14ms, 77MB)
테스트 16 〉	통과 (15.08ms, 86.2MB)
테스트 17 〉	통과 (21.12ms, 75.8MB)
테스트 18 〉	통과 (16.76ms, 72.5MB)
테스트 19 〉	통과 (11.71ms, 86.1MB)
테스트 20 〉	통과 (6.59ms, 78.5MB)
```