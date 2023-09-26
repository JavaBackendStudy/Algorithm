##### **📘 풀이한 문제**

- qr code
- https://school.programmers.co.kr/learn/courses/30/lessons/181903

##### **📜 대략적인 코드 설명**
```java

첫번째 버전
class Solution {
    public String solution(int q, int r, String code) {
    	if(q == 1 && r == 0) return code;
    	else {
        	StringBuilder sb = new StringBuilder();
        	
        	for(int i=r; i<code.length(); i+=q) {
        		sb.append(code.charAt(i));
            }
        	
        	return sb.toString();
    	}
    }
}

테스트 1 〉	통과 (0.04ms, 78.2MB)
테스트 2 〉	통과 (0.03ms, 78.1MB)
테스트 3 〉	통과 (0.06ms, 75.6MB)
테스트 4 〉	통과 (0.02ms, 78.7MB)
테스트 5 〉	통과 (0.02ms, 82.1MB)
테스트 6 〉	통과 (0.12ms, 76.5MB)
테스트 7 〉	통과 (0.06ms, 79.3MB)
테스트 8 〉	통과 (0.07ms, 75.4MB)
테스트 9 〉	통과 (0.04ms, 77.7MB)
테스트 10 〉	통과 (0.02ms, 77.1MB)
테스트 11 〉	통과 (0.05ms, 74.9MB)
테스트 12 〉	통과 (0.03ms, 75.3MB)
테스트 13 〉	통과 (0.06ms, 72.2MB)
테스트 14 〉	통과 (0.07ms, 75.8MB)
테스트 15 〉	통과 (0.08ms, 75.6MB)
테스트 16 〉	통과 (0.05ms, 76.3MB)
테스트 17 〉	통과 (0.03ms, 74.6MB)
테스트 18 〉	통과 (0.09ms, 75.6MB)
테스트 19 〉	통과 (0.03ms, 74.6MB)
테스트 20 〉	통과 (0.04ms, 70.2MB)

두번째 버전
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
    public String solution(int q, int r, String code) {
    	if(q == 1 && r == 0) return code;
    	else {
        	return IntStream.range(r, code.length())
        			 .filter(i -> i%q == r)
        			 .mapToObj(i -> String.valueOf(code.charAt(i)))
        			 .collect(Collectors.joining(""));
    	}
    }
}
테스트 1 〉	통과 (13.34ms, 76.7MB)
테스트 2 〉	통과 (10.05ms, 69.6MB)
테스트 3 〉	통과 (8.95ms, 83.8MB)
테스트 4 〉	통과 (3.64ms, 73.4MB)
테스트 5 〉	통과 (0.02ms, 81MB)
테스트 6 〉	통과 (3.02ms, 71.9MB)
테스트 7 〉	통과 (2.98ms, 73.6MB)
테스트 8 〉	통과 (5.98ms, 82.3MB)
테스트 9 〉	통과 (4.52ms, 84.3MB)
테스트 10 〉	통과 (12.78ms, 69.1MB)
테스트 11 〉	통과 (10.93ms, 81.9MB)
테스트 12 〉	통과 (4.17ms, 79.6MB)
테스트 13 〉	통과 (3.96ms, 65.1MB)
테스트 14 〉	통과 (3.40ms, 72.7MB)
테스트 15 〉	통과 (4.11ms, 77.8MB)
테스트 16 〉	통과 (3.94ms, 73.7MB)
테스트 17 〉	통과 (19.71ms, 77.4MB)
테스트 18 〉	통과 (14.16ms, 73.5MB)
테스트 19 〉	통과 (3.29ms, 74MB)
테스트 20 〉	통과 (4.38ms, 79.4MB)
```
