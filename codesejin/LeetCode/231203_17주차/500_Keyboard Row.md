
# [LeetCode] Keyboard Row
## 문제 링크: https://leetcode.com/problems/keyboard-row/
## 문제 설명 : 

- 주어진 문자열 배열 words가 주어지면 미국 키보드의 한 줄만을 사용하여 입력할 수 있는 단어를 반환합니다.
- 아래 이미지와 같이 미국 키보드에서:
-  첫 번째 줄에는 문자 "qwertyuiop"이 있습니다.
-  두 번째 줄에는 문자 "asdfghjkl"이 있습니다.
-  세 번째 줄에는 문자 "zxcvbnm"이 있습니다.


```java

import java.util.*;
class Solution {
    public String[] findWords(String[] words) {

        HashMap<Character, Integer> rowMap = new HashMap<>();// 문자와 행 위치(키보드 위치)
        String[] rows = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        for (int i = 0; i < rows.length; i++) {
            for (char c : rows[i].toCharArray()) {
                rowMap.put(c, i);
            }
        }
        List<String> result = new ArrayList<>();

        for (String word : words) {
            if (isValidWord(word.toLowerCase(), rowMap)) {
                result.add(word);
            }
        }

        return result.toArray(new String[0]);
    }

    private boolean isValidWord(String word, HashMap<Character, Integer> rowMap) {
        int row = rowMap.get(word.charAt(0)); // 문자열의 첫번째 글자의 위치 가져오기
        for (char c : word.toCharArray()) {
            if (rowMap.get(c) != row) {
                return false; // 현재 글자의 저장된 위치와 첫 글자의 위치가 다를 경우
            }
        }
        return true; // 모든 글자가 같은 위치
    }
}
```
```text
runtime : 1ms
beats : 48.85%
memory :40.48mb
beats : 58.72%
```