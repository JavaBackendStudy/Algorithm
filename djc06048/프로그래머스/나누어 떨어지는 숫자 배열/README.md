## 문제링크
https://school.programmers.co.kr/learn/courses/30/lessons/12910

## 내풀이
```
테스트 1 〉	통과 (0.39ms, 75.9MB)
테스트 2 〉	통과 (0.39ms, 73.7MB)
테스트 3 〉	통과 (0.40ms, 84.3MB)
테스트 4 〉	통과 (0.48ms, 80.3MB)
테스트 5 〉	통과 (0.60ms, 72.4MB)
테스트 6 〉	통과 (1.66ms, 85.5MB)
테스트 7 〉	통과 (0.42ms, 83.3MB)
테스트 8 〉	통과 (0.35ms, 74.4MB)
테스트 9 〉	통과 (0.37ms, 80MB)
테스트 10 〉	통과 (0.52ms, 83.7MB)
테스트 11 〉	통과 (0.55ms, 73MB)
테스트 12 〉	통과 (0.38ms, 75.5MB)
테스트 13 〉	통과 (0.45ms, 76.8MB)
테스트 14 〉	통과 (0.65ms, 79.6MB)
테스트 15 〉	통과 (0.44ms, 79MB)
테스트 16 〉	통과 (0.40ms, 78.4MB)
```

## 다른풀이
```java
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
class Solution {
    public int[] solution(int[] arr, int divisor) {
        
        List<Integer> arr2=new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            if(arr[i]%divisor==0) arr2.add(arr[i]);
        }
        if(arr2.size()==0) arr2.add(-1);
       
        return arr2.stream().mapToInt(s->s).sorted().toArray();
    }
}
-------------------------------------
테스트 1 〉	통과 (2.53ms, 77.5MB)
테스트 2 〉	통과 (3.25ms, 84.7MB)
테스트 3 〉	통과 (4.65ms, 84.5MB)
테스트 4 〉	통과 (3.58ms, 80.3MB)
테스트 5 〉	통과 (3.19ms, 77.2MB)
테스트 6 〉	통과 (4.76ms, 91.7MB)
테스트 7 〉	통과 (2.66ms, 75.8MB)
테스트 8 〉	통과 (2.89ms, 76.4MB)
테스트 9 〉	통과 (3.04ms, 84.6MB)
테스트 10 〉	통과 (10.40ms, 90.5MB)
테스트 11 〉	통과 (3.80ms, 77.5MB)
테스트 12 〉	통과 (2.72ms, 77.5MB)
테스트 13 〉	통과 (3.44ms, 80.6MB)
테스트 14 〉	통과 (2.75ms, 78.8MB)
테스트 15 〉	통과 (2.38ms, 74.5MB)
테스트 16 〉	통과 (2.62ms, 75.9MB)
```
