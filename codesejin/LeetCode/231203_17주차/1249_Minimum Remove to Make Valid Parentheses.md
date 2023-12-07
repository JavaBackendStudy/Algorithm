
# [LeetCode] Minimum Remove to Make Valid Parentheses
## 문제 링크: https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/description/
## 문제 설명 :

- '(', ')' 및 영어 소문자로 이루어진 문자열 s가 주어진다.
- 귀하의 작업은 결과 괄호 문자열이 유효하도록 만들기 위해 최소한의 괄호('(' 또는 ')', 어느 위치에서든)를 제거하고 유효한 문자열을 반환하는 것이다.
- 공식적으로 괄호 문자열은 다음 조건 중 하나일 때만 유효하다:
- 빈 문자열이거나 소문자 문자만 포함하거나
- AB로 쓸 수 있으며 (A와 B가 유효한 문자열인 경우) 또는
- (A)로 쓸 수 있으며 (A가 유효한 문자열인 경우)

## 문제 풀이:
1. 우선 문자열에 들어간 괄호가 올바른 괄호인지 아닌지 판단한다.
   2. stack이 비어져있으면 올바른 괄호, 안 비어져있으면 올바르지 않은 괄호
3. 남아있는 stack을 Set으로 각 인덱스 위치를 저장
4. StringBuilder에 append해주기 위해 다시 입력받은 문자열을 순회하는데, 괄호인데, set에 포함되어있을 경우 저장 X

```java
public class Solution { 
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>(); // 괄호의 위치를 저장할 스택

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else if (c == ')') {
                if (!stack.isEmpty() && s.charAt(stack.peek()) == '(') {
                    stack.pop(); // 유효한 괄호인 경우 스택에서 제거
                } else {
                    stack.push(i); // 유효하지 않은 괄호이므로 스택에 추가
                }
            }
        }

        Set<Integer> invalidIndices = new HashSet<>(stack);

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!Character.isAlphabetic(c) && invalidIndices.contains(i)) {
                continue; // 유효하지 않은 괄호인 경우, append하지 않고 다음 반복으로 진행
            }
            sb.append(c);
        }

        return sb.toString();
    }
}
```
```text
runtime : 34ms
beats : 14.08%
memory :44.46mb
beats : 45.43%
```