
# [LeetCode] Restore the Array From Adjacent Pairs
## 문제 링크: https://leetcode.com/problems/restore-the-array-from-adjacent-pairs/description/


## 문제 설명 :

- 이 문제는 n개의 고유한 원소로 이루어진 정수 배열 nums가 있지만, 해당 배열을 잊어버렸다고 가정한 상황에서, nums의 모든 인접한 원소 쌍을 기억하고 있는 경우입니다.
- 크기가 n-1인 2차원 정수 배열 adjacentPairs가 주어지며, 각각의 adjacentPairs[i] = [ui, vi]는 nums에서 원소 ui와 vi가 서로 인접하다는 것을 나타냅니다.
- 모든 adjacentPairs[i]는 [nums[i], nums[i+1]] 또는 [nums[i+1], nums[i]]로 존재할 것이 보장됩니다. 또한, 쌍은 어떤 순서로든 나타날 수 있습니다.
- 원래 배열 nums를 반환합니다. 여러 해결책이 존재할 경우, 그 중 아무 것이나 반환합니다.

## 문제 풀이

1. computeIfAbsent()를 이용해서 하나의 숫자와 연관된 모든 숫자를 List로 저장
   -1: [3]
   -3: [4, 3]
   3: [-1, -3]
   4: [-10, -3]
   -10: [4]
2. 위와 같이 저장된것 중에서 nums에 올 첫 번째 요소를 찾는다. 각 맨 앞의 원소와 뒤의 원소는 한번만 나타나고 나머지는 쌍으로 나타난다.
3. computeIfAbsent 메서드는 주어진 키에 대한 값이 존재하지 않을때 특정 연산의 결과로 매핑시켜줌
4. 나머지 원소를 순회하면서 찾은 원소는 방문했다고 set에 저장하고, 리스트에 넣어둔 인접한 값을 result에 붙임

```java
import java.util.*;

public class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, List<Integer>> adjacentMap = new HashMap<>();

        // 인접한 숫자들을 해시 맵에 저장
        for (int[] pair : adjacentPairs) {
            adjacentMap.computeIfAbsent(pair[0], key -> new ArrayList<>()).add(pair[1]);
            adjacentMap.computeIfAbsent(pair[1], key -> new ArrayList<>()).add(pair[0]);
        }

        // 첫 번째 요소를 찾음
        int n = adjacentMap.size();
        int[] result = new int[n];
        for (Map.Entry<Integer, List<Integer>> entry : adjacentMap.entrySet()) {
            if (entry.getValue().size() == 1) {
                result[0] = entry.getKey();
                break;
            }
        }

        result[1] = adjacentMap.get(result[0]).get(0);

        // 찾은 원소는 Set에 추가
        Set<Integer> visited = new HashSet<>();
        visited.add(result[0]);
        visited.add(result[1]);
        
        for (int i = 2; i < n; i++) {
            List<Integer> neighbors = adjacentMap.get(result[i - 1]);
            for (int neighbor : neighbors) {
                if (!visited.contains(neighbor)) {
                    result[i] = neighbor;
                    visited.add(neighbor);
                }
            }
        }

        return result;

    }
}
```
```text
runtime : 84ms
beats : 70.81%
memory : 26.32mb
beats : 26.32%
```


## 꿀팁

- computeIfAbsent와 비슷하게 putIfAbsent를 이용할 수 도 있음
```java
public class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, List<Integer>> adjacentMap = new HashMap<>();
        for (int[] pair : adjacentPairs) {
            adjacentMap.putIfAbsent(pair[0], new ArrayList<>());
            adjacentMap.putIfAbsent(pair[1], new ArrayList<>());
            adjacentMap.get(pair[0]).add(pair[1]);
            adjacentMap.get(pair[1]).add(pair[0]);
        }
    }
}
```