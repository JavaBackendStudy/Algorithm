# [LeetCode] Validate Stack Sequences
## 문제 링크: https://leetcode.com/problems/validate-stack-sequences/

## 문제 설명 :

- 두 개의 서로 다른 값으로 이루어진 정수 배열 pushed와 popped가 주어졌을 때, 
- 이 배열들이 초기에 비어있는 스택에서의 push와 pop 연산의 결과일 수 있다면 true를 반환하고, 그렇지 않다면 false를 반환합니다.

## 문제 풀이

1. pushed배열에 있는것 차례대로 stack에 넣어준다.
2. 만일 stack의 peek과 popped의 원소가 같을 경우 계속 빼준다.
3. stack이 비어있으면 stack순서가 맞는것이라서 true이고 아닐경우 false

```java
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int idx = 0;
        for (int i = 0; i < pushed.length; i++) {
            stack.push(pushed[i]); 
            while (!stack.isEmpty() && stack.peek() == popped[idx]) {
                stack.pop();
                idx++;
            }
        }
        return stack.isEmpty();
    }
}
```

```text
Runtime : 2 ms
Memory: 43.4 MB
```