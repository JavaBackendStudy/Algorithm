class Solution {
    public int solution(int n) {
        int i=0;
        while(true){
            if(fact(i)>n) break;
            else i++;
        }
        return i-1;
       
    }
    private int fact(int n){
        if(n==0) return 1;
        else return n*fact(n-1);
    }
   
}
