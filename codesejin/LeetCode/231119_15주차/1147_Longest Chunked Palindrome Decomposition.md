# [LeetCode] Longest Chunked Palindrome Decomposition
## 문제 링크: https://leetcode.com/problems/longest-chunked-palindrome-decomposition/description/


## 문제 설명 :


- 주어진 문자열 text를 여러 개의 부분 문자열로 나누어야 합니다. 나눈 부분 문자열은 다음의 조건을 만족해야 합니다:

- subtexti는 비어있지 않은 문자열이어야 합니다.
- 나눈 부분 문자열들을 모두 이어붙였을 때, 다시 주어진 문자열 text가 되어야 합니다. 즉, subtext1 + subtext2 + ... + subtextk == text여야 합니다.
- 모든 유효한 i 값에 대해 subtexti == subtextk - i + 1이어야 합니다. 즉, 1 <= i <= k일 때, subtexti는 subtextk - i + 1과 같아야 합니다.
- 이러한 조건을 만족하는 가장 큰 값의 k를 반환해야 합니다.

## 문제 풀이

1. 해시 문제라고 써져있지만, 해시로 푸는 방법이 생각이 안남, 힌트에 롤링해시로 풀라는데, 롤링해시 뭔지 모름..
2. 예시 봤을때 이전에 풀었던것처럼 앞이랑 뒤에서부터 움직이면서 비교하면 될거라고 생각함
3. substring 사용해서 앞이랑, 뒤에서부터 인덱스 움직이면서 똑같을때 까지 반복함
4. 접두사, 접미사가 똑같을 경우 +2 해주고 text를 동일한 부분 제거하고 재할당함
5. "elvtoelvto"와 같이 동일한 문자열이 붙어있을 수 있으므로 재할당했을때 문자열이 비어있으면 1개 빼줌

```java
class Solution {
    public int longestDecomposition(String text) {
        int answer = 1;
        int n = text.length();

        for (int idx = 1; idx <= n / 2; idx++) {
            String prefix = text.substring(0, idx);
            String suffix = text.substring(n - idx, n);

            if (prefix.equals(suffix)) {
                answer += 2;
                text = text.substring(idx, n - idx);
                idx = 0;
                n = text.length();
                if (text.isBlank()) answer --;

            }
        }

        return answer;
    }
}
```

```text
Runtime : 2 ms
Memory: 43.92 MB
```