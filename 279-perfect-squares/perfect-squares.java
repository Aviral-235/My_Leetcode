class Solution {
    public int check(int n,int i,int [][]dp){
        if(n==0){
            return 0;
        }
        if((i*i)>n){
            return 1_000_000_000;
        }
        if(dp[n][i]!=-1){
            return dp[n][i];
        }
        else{
            int not_take=check(n,i+1,dp);
            int take=Integer.MAX_VALUE;
            if(n>=(i*i)){
                take=1+check(n-(i*i),i,dp);
            }
            return dp[n][i]=Math.min(take,not_take);
        }
    }
    public int numSquares(int n) {
        int maxI = (int) Math.sqrt(n) + 1;
        int dp[][]=new int[n+1][maxI+1];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        return check(n,1,dp);
    }
}