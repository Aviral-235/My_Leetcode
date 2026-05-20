class Solution {
    int count(int n,int m,String s1,String s2,int dp[][]){
        if(m<0){
            return 1;
        }
         if(n<0){
            return 0;
         }
         if(dp[n][m]!=-1){
            return dp[n][m];
         }
         else{
            if(s1.charAt(n)==s2.charAt(m)){
                return dp[n][m]=count(n-1,m-1,s1,s2,dp)+count(n-1,m,s1,s2,dp);
             }
             return dp[n][m]=count(n-1,m,s1,s2,dp);
         }
    }
    public int numDistinct(String s, String t) {
        int dp[][]=new int[s.length()][t.length()];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        return count(s.length()-1,t.length()-1,s,t,dp);
    }
}