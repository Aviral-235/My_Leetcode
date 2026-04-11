class Solution {
    public int lastStoneWeightII(int[] stones) {
        int sum=0;
        int n=stones.length;
        for(int x:stones){
            sum+=x;
        }
        boolean dp[][]=new boolean[n][sum+1];
        for(int i=0;i<dp.length;i++){
            dp[i][0]=true;
        }
        if(stones[0]<dp[0].length){
        dp[0][stones[0]]=true;
        }
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                boolean not_take=dp[i-1][j];
                boolean take=false;
                if(stones[i]<j){
                    take=dp[i-1][j-stones[i]];
                }
                dp[i][j]=(take||not_take);
            }
        }
        int mindiff=Integer.MAX_VALUE;
        for(int j=0;j<dp[0].length;j++){
            if(dp[dp.length-1][j]==true){
                int s1=j;
                int s2=sum-s1;
                mindiff=Math.min(mindiff,Math.abs(s2-s1));
            }
        }
        return mindiff;
    }
}