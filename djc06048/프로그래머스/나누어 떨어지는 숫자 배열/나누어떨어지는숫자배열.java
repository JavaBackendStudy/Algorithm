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
       
        int[] answer=new int[arr2.size()];
        for(int i=0;i<answer.length;i++){
            answer[i]=arr2.get(i);
        }
        Arrays.sort(answer);
        return answer;
    }
}
