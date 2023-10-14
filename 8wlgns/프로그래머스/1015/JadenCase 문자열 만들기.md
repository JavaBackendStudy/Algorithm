##### **📘 풀이한 문제**

- JadenCase 문자열 만들기
- https://school.programmers.co.kr/learn/courses/30/lessons/12951#
  
##### **📜 대략적인 코드 설명**
- string.split() 함수를 사용한다.
- ascii code를 문자열화 하려면 (char) ascii code + ""을 한다.
```java
class Solution {
    public String solution(String s) {
    	String[] strList = s.split("\\s+");
    	String[] blankList = s.split("\\w+");
    	
    	StringBuilder sb = new StringBuilder();
    	
    	for(int i=0; i<strList.length; i++) {
    		StringBuilder temp = new StringBuilder(strList[i]);
    		
    		for(int j=0; j<strList[i].length(); j++) {
    			char ch = temp.charAt(j);
        		
    			if(j == 0 && ch >= 'a' && ch <= 'z') {
            		temp.replace(j, j+1, (char)('A'+ch-'a') + "");
    			}
    			if(j != 0 && ch >= 'A' && ch <= 'Z') {
    				    temp.replace(j, j+1, (char)('a'+ch-'A') + "");
    			}
    		}
    		
    		sb.append(temp);
    		if(i+1 < blankList.length) sb.append(blankList[i+1]);
    	}
    	
    	return sb.toString();
    }
}
```
