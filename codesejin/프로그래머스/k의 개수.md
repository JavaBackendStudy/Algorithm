# [프로그래머스] k의 개수

---

## 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/120887

<br>

## 문제 설명:

- 1부터 13까지의 수에서, 1은 1, 10, 11, 12, 13 이렇게 총 6번 등장합니다. 
- 정수 i, j, k가 매개변수로 주어질 때, i부터 j까지 k가 몇 번 등장하는지 return 하도록 solution 함수를 완성해주세요.

---

## 풀이 설명

- j-i+1 한 만큼 사이즈의 배열을 만든다. 이유는 값을 집어넣을때 array out of bound exception가 안나오게 하기 위해.
- i부터 j까지 정수 배열에 담아준다.
- 해당 배열에 있는 정수를 하나씩 꺼내서 String타입으로 쪼갠 뒤 k와 일치하면 ++

```java
class Solution {
    public int solution(int i, int j, int k) {
        int answer = 0;

        int[] ints = new int[j-i+1];
        int idx = 0;
        for (int l = i; l <= j; l++) {
            ints[idx++] = l;
        }

        for (int l = 0; l < ints.length; l++) {
            int target = ints[l];
            for (int m = 0; m < String.valueOf(target).length(); m++) {
                int unit = Integer.parseInt(String.valueOf(String.valueOf(ints[l]).charAt(m)));
                if (unit == k)
                    answer ++;
            }

        }
        return answer;
    }

}

```

```text
테스트 1 〉	통과 (60.01ms, 101MB)
테스트 2 〉	통과 (0.04ms, 81.8MB)
테스트 3 〉	통과 (0.05ms, 78MB)
테스트 4 〉	통과 (17.79ms, 81.4MB)
테스트 5 〉	통과 (11.32ms, 85.9MB)
테스트 6 〉	통과 (0.13ms, 67.8MB)
테스트 7 〉	통과 (2.49ms, 75.8MB)
테스트 8 〉	통과 (23.82ms, 99.7MB)
```


## 다른 사람 풀이

- 1. 중첩 반복문을 통해서 i부터 j까지 숫자를 10으로 나눈 나머지가 k와 일치하다면 +를 해줍니다.
- 2. tmp가 0이 아닐 경우에만 분기처리를 하게 됩니다.
- 3. tmp가 10의 자리 수 이상이 될 경우에는 나누기 10해서 일의 자리수를 다시 체크합니다.


```java
class Solution {
    public int solution(int i, int j, int k) {
        int answer = 0;

        for (int num = i; num <= j; num++){
            int tmp = num;
            while (tmp != 0){
                if (tmp % 10 == k)
                    answer++;
                tmp /= 10;
            }
        }
        return answer;
    }
}

```

```text
테스트 1 〉	통과 (4.61ms, 78.8MB)
테스트 2 〉	통과 (0.01ms, 77.6MB)
테스트 3 〉	통과 (0.02ms, 76.7MB)
테스트 4 〉	통과 (0.91ms, 64.8MB)
테스트 5 〉	통과 (0.75ms, 79MB)
테스트 6 〉	통과 (0.02ms, 71.1MB)
테스트 7 〉	통과 (0.08ms, 79MB)
테스트 8 〉	통과 (1.94ms, 69.7MB)
```

## 성능 비교

- 내가 푼 풀이:
주어진 범위 내의 숫자를 먼저 배열로 생성한 후에, 각 숫자를 문자열로 변환하여 각 자리 숫자를 추출하고 비교합니다.
이 코드는 주어진 범위 내의 숫자 개수와 무관하게 이미 배열에 모든 숫자가 저장되어 있으므로 내부 반복문의 실행 횟수는 상수입니다.

- 다른 사람 풀이2:
주어진 범위 내의 각 숫자에 대해 자리별로 숫자를 추출하고 비교합니다.
이 코드는 주어진 범위의 숫자 개수에 따라서 내부 반복문의 실행 횟수가 결정됩니다. 
예를 들어 i=1, j=10000일 경우 1부터 10000까지의 숫자에 대해 각 숫자의 각 자리를 검사하므로 시간 복잡도가 크게 됩니다.