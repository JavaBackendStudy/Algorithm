
# [LeetCode] Optimal Partition of String
## 문제 링크: https://leetcode.com/problems/optimal-partition-of-string/description/


## 문제 설명 :

- 주어진 문자열 s를 하나 이상의 부분 문자열로 분할합니다. 
- 각 부분 문자열 내의 문자는 한 번 이상 나타나지 않아야 합니다. 
- 즉, 각 부분 문자열에서 특정 문자는 한 번만 나타나야 합니다.
- 이러한 분할에서 필요한 최소 부분 문자열 수를 반환합니다.

## 문제 풀이 1
1. 문자열 조작을 위해 StringBuilder사용
2. 동일한 문자 나오기 전까지 StringBuilder에 문자 붙이기
3. 동일한 문자 나오면 map에 추가하하면서 카운팅, StringBuilder는 초기화하고 새로운 문자열 붙이기
4. 남은 문자열 마지막에 다시 한번 map에 넣고 value값 더해주기

```java
class Solution {
    public int partitionString(String s) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i <  s.length(); i++) {
            char target = s.charAt(i);
            if (String.valueOf(sb).indexOf(target) == -1) {
                sb.append(target);
            } else {
                map.put(sb.toString(), map.getOrDefault(sb.toString(),0)+1);
                sb.delete(0,sb.length());
                sb.append(target);
            }
        }
        map.put(sb.toString(), map.getOrDefault(sb.toString(),0)+1);
        for (int x : map.values()) {
            answer += x;
        }
        return answer;
    }
}
```

```text
Runtime : 48 ms
Memory: 48.77 MB
```

## 문제 풀이 2

1. 왼쪽부터 오른쪽까지 확장하면서 얼만큼 substring할지가 관건이라고 생각함
2. "cuieokbs"와 같이 반복된 문자가 없는 문자열의 경우, 분할할 최소 숫자는 해당 문자열 자체로 1이기 때문에 answer를 1로 초기화
2. StringBuilder대신 substring사용하고 싶었고, 투포인터로 적용
3. right 포인터가 반복문을 통해 계속 증가하면서 target 문자를 찾고, left포인터랑 right 포인터로 찾은 substring문자열이랑 비교
4. 부분 문자열에 존재하는 경우 map에 넣고, left포인터를 right포인터 인덱스번호로 할당하면서 substring구간 초기화
5. 구해준 map의 value값들 합치기

```java
class Solution {
    public int partitionString(String s) {
        int answer = 1;
        HashMap<String, Integer> map = new HashMap<>();
        int left = 0,right = 0;
        
        while (right < s.length()) {
            char target = s.charAt(right);
            String substring = s.substring(left, right);
            // target문자가 부분 문자열에 존재하는 경우
            if (substring.indexOf(target) != -1) {
                // 문자열을 저장하고 초기화
                map.put(substring, map.getOrDefault(substring, 0) + 1);
                left = right;
            }
            
            right++;
        }
        for (int x : map.values()) {
            answer += x;
        }
        return answer;
    }
}
```
```text
Runtime : 35 ms
Memory: 48.6 MB
```

## 문제 풀이 3

1. Character를 String으로 형변환하는 과정에서 불필요한 메모리가 사용되고, 비효율적이라고 생각함
2. 오직 Charater로만 사용
3. Charater를 모두 map에 넣되, 이미 포함되어있는 key일 경우 map clear하고, 카운팅 ++

```java
import java.util.HashMap;

class Solution {
    public int partitionString(String s) {
        int answer = 1;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char target = s.charAt(i);
            if (map.containsKey(target)) { 
                map.clear();
                answer++;
            }
            map.put(target, 1);
        }
        return answer;
    }
}
```

```text
Runtime : 33 ms
Memory: 44.82 MB
```