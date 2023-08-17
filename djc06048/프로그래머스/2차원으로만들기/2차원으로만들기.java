import java.util.Arrays;
class Solution {
    public int[][] solution(int[] num_list, int n) {
        
        int arrayLength=num_list.length;
        int[][] answer =new int[arrayLength/n][n];
        int idx=0;
        int[] arr=new int[n];
        for(int i=0;i<arrayLength/n;i++){
            arr=new int[n];
            for(int j=0;j<n;j++){
                arr[j]=num_list[idx++];
            }            
            answer[i]=arr;
        }
        
        
        
        return answer;
    }
}
