# 문제링크
https://school.programmers.co.kr/learn/courses/30/lessons/181912/solution_groups?language=java&type=my

# 내풀이
```
테스트 1 〉	통과 (11.42ms, 103MB)
테스트 2 〉	통과 (9.46ms, 90.4MB)
테스트 3 〉	통과 (2.87ms, 76.6MB)
테스트 4 〉	통과 (2.05ms, 86.2MB)
테스트 5 〉	통과 (4.85ms, 82.8MB)
테스트 6 〉	통과 (4.60ms, 77.3MB)
테스트 7 〉	통과 (4.62ms, 88.6MB)
테스트 8 〉	통과 (5.56ms, 101MB)
테스트 9 〉	통과 (9.25ms, 98MB)
테스트 10 〉	통과 (6.85ms, 94.3MB)
테스트 11 〉	통과 (4.50ms, 91.6MB)

```


## 다른풀이
```java
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(String[] intStrs, int k, int s, int l) {
        List<Integer> arr=new ArrayList<>();
        StringBuilder sb=new StringBuilder();
        for(String now : intStrs){
            sb=new StringBuilder();
            for(int i=s;i<s+l;i++){
                sb.append(now.charAt(i));
            }
            int a=Integer.parseInt(sb.toString());
            
            if(a>k){
              arr.add(a);
            }
        }
       
       
        return arr.stream().mapToInt(i -> i).toArray();
        
    }
}
----------------------------
테스트 1 〉	통과 (12.07ms, 93.7MB)
테스트 2 〉	통과 (9.42ms, 98.9MB)
테스트 3 〉	통과 (6.70ms, 81.3MB)
테스트 4 〉	통과 (6.25ms, 90.4MB)
테스트 5 〉	통과 (26.30ms, 91.5MB)
테스트 6 〉	통과 (31.76ms, 95.6MB)
테스트 7 〉	통과 (7.58ms, 79.7MB)
테스트 8 〉	통과 (9.08ms, 84.7MB)
테스트 9 〉	통과 (10.36ms, 95MB)
테스트 10 〉	통과 (17.43ms, 80.3MB)
테스트 11 〉	통과 (7.31ms, 92.7MB)
```

## 느낀점
동적으로 추가되는 배열은 컬렉션의 ArrayList 활용하자

> ArrayList 등과 같은 Collection 프레임 워크의 데이터 구조는 기본 타입이 아닌 객체만 저장하게 되고, Wrapper Class를 사용하여 자동 방식과 언방식이 일어남
> 
> ArrayList<int> list = new ArrayList<>();  // compile error
