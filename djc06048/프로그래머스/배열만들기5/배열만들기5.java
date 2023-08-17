import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(String[] intStrs, int k, int s, int l) {
        List<Integer> arr=new ArrayList<>();
        StringBuilder sb=new StringBuilder();
        int cnt=0;
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

        int[] answer=new int[arr.size()];
        for(int i=0;i<arr.size();i++){
            answer[i]=arr.get(i);
        }


        return answer;
    }
}
