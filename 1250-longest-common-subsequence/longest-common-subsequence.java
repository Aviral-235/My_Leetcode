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
        int dp[][]=new int[text1.length()][text2.length()];
        for(int rows[]:dp){
            Arrays.fill(rows,-1);
        }
        return lcs(text1.length()-1,text2.length()-1,text1,text2,dp);
    }
}