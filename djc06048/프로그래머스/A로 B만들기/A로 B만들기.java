class Solution {
    public int solution(String before, String after) {
        String[] arr1=before.split("");
        String[] arr2=after.split("");
        Boolean[] visit=new Boolean[arr1.length];
        Arrays.fill(visit,false);
        for(int i=0;i<arr1.length;i++){
            for(int k=0;k<arr2.length;k++){
                if(visit[k]!=true){
                    if(arr1[i].equals(arr2[k])){
                        visit[k]=true;
                        break;
                    } 

                }

            }
        }

        for(Boolean i:visit){
            if(i==false) return 0;

        }
        return 1;

    }
}
