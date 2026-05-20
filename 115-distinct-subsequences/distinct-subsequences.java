class Solution {
    public int numDistinct(String s, String t) {
        int prev[]=new int[t.length()+1];
        
        prev[0]=1;
        
        for(int i=1;i<s.length()+1;i++){
            int curr[]=new int[t.length()+1];
            curr[0]=1;
            for(int j=1;j<prev.length;j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    curr[j]=prev[j-1]+prev[j];
             }
             else{
                 curr[j]=prev[j];
             }
             
            }
            prev=curr;
        }
        return prev[t.length()];
    }
}