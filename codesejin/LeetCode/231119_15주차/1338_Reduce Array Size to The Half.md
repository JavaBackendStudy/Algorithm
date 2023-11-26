# [LeetCode] Reduce Array Size to The Half

## 문제 링크: https://leetcode.com/problems/reduce-array-size-to-the-half/description/

## 문제 설명 :

- 주어진 정수 배열 arr이 있습니다. 
- 여러 정수를 선택하고 해당 정수들의 모든 발생을 배열에서 제거할 수 있습니다.
- 배열의 정수 중 최소한 절반 이상을 제거하기 위해 필요한 최소 집합 크기를 반환하세요.

```java

public class Solution {
    public int minSetSize(int[] arr) { 
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Map의 value로 최대 힙 구현
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        maxHeap.addAll(map.keySet());

        int count = 0;
        int setSize = 0;
        
        while (!maxHeap.isEmpty()) {
            int key = maxHeap.poll(); 
            count += map.get(key);
            setSize++;

            if (count >= arr.length / 2) {
                return setSize;
            }
        }

        return setSize;
    }
}
```
```text
Runtime :  38ms
Memory: 54.57 MB
```