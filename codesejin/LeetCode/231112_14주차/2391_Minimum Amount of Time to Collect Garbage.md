
# [LeetCode] Minimum Amount of Time to Collect Garbage
## 문제 링크: https://leetcode.com/problems/minimum-amount-of-time-to-collect-garbage/description/

## 문제 설명 :

- 주어진 배열 garbage는 각 집의 쓰레기 종류를 나타내며, garbage[i]는 i번째 집의 쓰레기 종류를 나타냅니다.
- 여기서 'M', 'P', 'G'는 각각 금속(Metal), 종이(Paper), 유리(Glass) 쓰레기를 나타냅니다. 각 쓰레기 유형을 줍는 데 걸리는 시간은 1분입니다.
- 또한, 배열 travel은 travel[i]가 i번째 집에서 i+1번째 집으로 이동하는 데 필요한 시간을 나타냅니다.
- 이 도시에는 금속, 종이, 유리 쓰레기 각각을 수거하는 쓰레기 트럭이 세 대 있습니다.
- 각 쓰레기 트럭은 집 0에서 시작하여 각 집을 순서대로 방문해야 합니다. 그러나 각 트럭은 모든 집을 방문할 필요는 없습니다.
- 한 번에 하나의 쓰레기 트럭만 사용할 수 있습니다. 한 트럭이 운전하거나 쓰레기를 줍는 동안 다른 두 트럭은 아무 것도 할 수 없습니다.
- 모든 쓰레기를 수거하는 데 필요한 최소 시간을 반환하세요.

## 풀이 설명

1. 각 금속, 종이,유리가 있는 마지막장소까지만 돌아야 하므로 반복문을 뒤에서 부터 순회한다.
   - 쓰레기가 존재하고, 아직 마지막 장소를 아직 구하지 않았을 경우, 각 last변수에 해당 마지막 장소인 인덱스 할당
2. 어차피 모든 area에는 쓰레기가 있으므로 줍는 시간 1분은 길이로 대체
3. travel배열을 순회하면서 마지막 장소 인덱스보다 작다면 해당 travel원소 추가

```java
class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        //  'M', 'P', 'G' -> 금속(Metal), 종이(Paper), 유리(Glass)
        // garbage = ["G","P","GP","GG"], travel = [2,4,3]
        int sum = 0;
        int lastMetal = 0, lastPaper = 0, lastGlass = 0;
        int metal = 0, paper = 0, glass = 0;
        for (int i = garbage.length-1; i >= 0; i--) {
            String area = garbage[i];
            if(area.indexOf("M") != -1 && lastMetal == 0) lastMetal = i;
            if(area.indexOf("P") != -1 && lastPaper == 0) lastPaper = i;
            if(area.indexOf("G") != -1 && lastGlass == 0) lastGlass = i;
            sum += area.length();
        }
        for (int i = 0; i < travel.length; i++) {
            if (i < lastMetal) metal += travel[i];
            if (i < lastPaper) paper += travel[i];
            if (i < lastGlass) glass += travel[i];
        }
        return metal + paper + glass + sum;
    }
}
```
```text
Runtime : 22 ms
Memory: 61.95 MB
```