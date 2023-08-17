## 문제링크
https://school.programmers.co.kr/learn/courses/30/lessons/181912/solution_groups?language=java&type=my

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
```

## 느낀점
동적으로 추가되는 배열은 컬렉션의 ArrayList 활용하자

> ArrayList 등과 같은 Collection 프레임 워크의 데이터 구조는 기본 타입이 아닌 객체만 저장하게 되고, Wrapper Class를 사용하여 자동 방식과 언방식이 일어남
> 
> ArrayList<int> list = new ArrayList<>();  // compile error
