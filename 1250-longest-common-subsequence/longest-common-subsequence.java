class Solution {
    public int lcs(int n,int m,String s1,String s2,int dp[][]){
        if(n<0||m<0){
            return 0;
        }
        if(dp[n][m]!=-1){
            return dp[n][m];
        }
        else{
            if(s1.charAt(n)==s2.charAt(m)){
                return dp[n][m]=1+lcs(n-1,m-1,s1,s2,dp);
            }
            return dp[n][m]=Math.max(lcs(n-1,m,s1,s2,dp),lcs(n,m-1,s1,s2,dp));
        }
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int dp[][]=new int[text1.length()+1][text2.length()+1];
        for(int i=0;i<=text1.length();i++){
            dp[i][0]=0;
        }
        for(int j=0;j<text2.length()+1;j++){
            dp[0][j]=0;
        }
        for(int i=1;i<text1.length()+1;i++){
            for(int j=1;j<text2.length()+1;j++){
                 if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }   
                else{
                     dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }
}