class Solution {
    public int maxCoins(int[] nums) {
        int[] extendedNums = new int[nums.length + 2];
        extendedNums[0] = 1;
        extendedNums[extendedNums.length - 1] = 1;
        for (int i = 0; i < nums.length; i++) {
            extendedNums[i + 1] = nums[i];
        }
        int n = extendedNums.length;
        int dp[][]=new int[n][n];
        for(int i=0;i<n-1;i++){
            dp[i][i+1]=0;
        }
        for(int gap=2;gap<n;gap++){
            for(int i=0;i+gap<n;i++){
                int j=i+gap;
                dp[i][j]=0;
                for(int k=i+1;k<j;k++){
                    dp[i][j]=Math.max(dp[i][j],extendedNums[i]*extendedNums[k]*extendedNums[j]+dp[i][k]+dp[k][j]);
                }
            }
        }
        return dp[0][n-1];
    }
}