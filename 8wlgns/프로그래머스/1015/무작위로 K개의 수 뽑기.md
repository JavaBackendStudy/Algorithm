##### **📘 풀이한 문제**

- 무작위로 K개의 수 뽑기
- https://school.programmers.co.kr/learn/courses/30/lessons/181858#qna
  
##### **📜 대략적인 코드 설명**
- LinkedList의 contains함수를 사용한다. (TreeSet을 사용하여 시도하였으나, 애초에 정렬되어 저장되고 나오기에 실패함)

```java
import java.util.Arrays;
import java.util.LinkedList;

class Solution {
    public int[] solution(int[] arr, int k) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        
        for(int num: arr) {
        	if(!list.contains(num))
        		list.add(num);
        }
        
        int[] randomValues = list.stream().mapToInt(Integer::intValue).toArray();
        
        if(randomValues.length == k) {
        	return randomValues;
        } else if(randomValues.length > k) {
        	return Arrays.copyOf(randomValues, k);
        } else {
        	int[] answer = new int[k];
            Arrays.fill(answer, -1);
            
            for(int i=0; i<answer.length; i++) 
            	answer[i] = i < randomValues.length ? randomValues[i] : answer[i];
            
            return answer;
        }
    }
}
테스트 1 〉	통과 (2.92ms, 81.1MB)
테스트 2 〉	통과 (1.96ms, 78.8MB)
테스트 3 〉	통과 (2.22ms, 76.1MB)
테스트 4 〉	통과 (2.20ms, 73.2MB)
테스트 5 〉	통과 (2.20ms, 75.7MB)
테스트 6 〉	통과 (2.45ms, 72.5MB)
테스트 7 〉	통과 (3.68ms, 78.4MB)
테스트 8 〉	통과 (2.82ms, 73.9MB)
테스트 9 〉	통과 (6.32ms, 75.7MB)
테스트 10 〉	통과 (24.77ms, 77.8MB)
테스트 11 〉	통과 (11.11ms, 83.4MB)
테스트 12 〉	통과 (6.30ms, 80.1MB)
테스트 13 〉	통과 (21.68ms, 83.6MB)
테스트 14 〉	통과 (6.56ms, 77.7MB)
테스트 15 〉	통과 (7.74ms, 77.9MB)
테스트 16 〉	통과 (36.02ms, 92.9MB)
테스트 17 〉	통과 (46.57ms, 99.7MB)
테스트 18 〉	통과 (36.81ms, 92.5MB)
테스트 19 〉	통과 (469.51ms, 84.3MB)
테스트 20 〉	통과 (413.92ms, 80.1MB)
```
