import java.util.Arrays;
class Solution {
    public String solution(String[] seoul) {
        int loc=Arrays.asList(seoul).indexOf("Kim");
        System.out.println(loc);
        StringBuilder sb=new StringBuilder();
        sb.append("김서방은 ").append(loc).append("에 있다");
        return sb.toString();
    }
}
