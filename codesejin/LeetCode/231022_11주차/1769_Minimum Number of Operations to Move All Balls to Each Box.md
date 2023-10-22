# [LeetCode] Minimum Number of Operations to Move All Balls to Each Box

## 문제 링크: https://leetcode.com/problems/minimum-number-of-operations-to-move-all-balls-to-each-box/description/

## 문제 설명 :

- 주어진 상자가 n개 있습니다. 길이가 n인 이진 문자열 boxes가 주어집니다.
- 여기서 boxes[i]는 i번째 상자가 비어있는 경우 '0'이고, 하나의 공이 들어있는 경우 '1'입니다. 
- 한 번의 작업에서 상자에서 인접한 상자로 공 하나를 옮길 수 있습니다.
- 상자 i는 상자 j와 인접하다고 할 때 abs(i - j) == 1입니다. 이렇게 한 후에 일부 상자에는 두 개 이상의 공이 들어 있을 수 있습니다. 
- n개의 상자에 모든 공을 이동하기 위해 필요한 최소 작업 횟수를 나타내는 크기가 n인 배열 answer를 반환해야 합니다.
- 이 배열에서 answer[i]는 i번째 상자로 모든 공을 이동하기 위해 필요한 최소 작업 횟수입니다. 
- 각 answer[i]는 상자의 초기 상태를 고려하여 계산됩니다. 
- 예를 들어:
- boxes = "110"인 경우, 출력은 [1, 1, 3]입니다. 각 상자에 대한 설명은 다음과 같습니다:
- 첫 번째 상자: 두 번째 상자에서 첫 번째 상자로 한 번의 작업으로 한 개의 공을 이동해야 합니다. 
- 두 번째 상자: 첫 번째 상자에서 두 번째 상자로 한 번의 작업으로 한 개의 공을 이동해야 합니다. 
- 세 번째 상자: 첫 번째 상자에서 세 번째 상자로 두 번의 작업으로, 두 번째 상자에서 세 번째 상자로 한 번의 작업으로 공을 이동해야 합니다.

## 풀이 설명 :

1. boxes를 charArray로 쪼개준다.
2. 각 인덱스 별로 순회하면서 첫번째 for문의 인덱스값에서 2번째 for문의 인덱스값을 차감한 절대값을 누적한다
3. 누적한 값을 answer배열에 넣는다.
4. [참고] toCharArray()를 쓰지 않고 charAt()을 할 경우 성능이 더 느림. 
   5. Why? 원래 charAt()을 사용하면 배열을 생성하지 않아서 내부적인 toCharArray()보다  처리속도가 더 빠르지만, 
   6. 2중 for문에 중복된 조회(계산)를 해야하므로 배열에 저장해서 인덱스로 가져오는 것보다 느려짐

```java
// Input : "001011" , Output: [11,8,5,4,3,4]
//        0 : 2 + 4 + 5;
//        1 : 1 + 3 + 4
class Solution {
    public int[] minOperations(String boxes) {
        int[] answer = new int[boxes.length()];
        char[] charArray = boxes.toCharArray();
        for (int i = 0; i < boxes.length(); i++) {
            int abs = 0;
            for (int j = 0; j < boxes.length(); j++) {
                if (charArray[j] == '1'){
                    abs += Math.abs(i - j);
                }
            }
            answer[i] = abs;
        }
        return answer;
    }
}
```
```text
Runtime : 73 ms
Memory: 43.5 MB
```