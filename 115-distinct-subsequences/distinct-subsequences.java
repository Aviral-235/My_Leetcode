class Solution {
    // int count(int n,int m,String s1,String s2,int dp[][]){
    //     if(m<0){
    //         return 1;
    //     }
    //      if(n<0){
    //         return 0;
    //      }
    //      if(dp[n][m]!=-1){
    //         return dp[n][m];
    //      }
    //      else{
            
    //      }
    // }
    public int numDistinct(String s, String t) {
        int dp[][]=new int[s.length()+1][t.length()+1];
        for(int j=1;j<dp[0].length;j++){
            dp[0][j]=0;
        }
        for(int i=0;i<dp.length;i++){
            dp[i][0]=1;
        }
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
             }
             else{
                 dp[i][j]=dp[i-1][j];
             }
            }
        }
        return dp[s.length()][t.length()];
    }
}