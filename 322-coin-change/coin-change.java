class Solution {
    public static int getmin(int[]coins,int val,int n){
        int dp[]=new int[val+1];
        dp[0]=0;
        for(int i=1;i<dp.length;i++){
            dp[i]=Integer.MAX_VALUE;
            for(int j=0;j<n;j++){
                if(coins[j]<=i){
                    int sub_res=dp[i-coins[j]];
                    if(sub_res!=Integer.MAX_VALUE){
                        dp[i]=Math.min(dp[i],1+sub_res);
                    }
                }
                

            }

            }
            return dp[val];
        }

    
    public int coinChange(int[] coins, int amount) {
    int res=getmin(coins,amount,coins.length);
    if(res==Integer.MAX_VALUE){
        return -1;
    }
    return res;    
    }
}
