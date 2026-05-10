class Solution {
    public int min_cost(int[] days,int[]cost,int n,int covered,int dp[][]){
        if(n==days.length){
            return 0;
        }
        if(dp[n][covered]!=-1){
            return dp[n][covered];
        }
        else{
        int oneday=Integer.MAX_VALUE;
        int sevenday=Integer.MAX_VALUE;
        int month=Integer.MAX_VALUE;
        if(days[n]>covered){
             oneday=cost[0]+min_cost(days,cost,n+1,days[n],dp);
        }
        if(days[n]>covered){
             sevenday=cost[1]+min_cost(days,cost,n+1,days[n]+6,dp);
        }
        if(days[n]>covered){
             month=cost[2]+min_cost(days,cost,n+1,days[n]+29,dp);
        }
        if(days[n]<=covered){
            return dp[n][covered]=min_cost(days,cost,n+1,covered,dp);
        }
        return dp[n][covered]=Math.min(oneday,Math.min(sevenday,month));
        }
    }
    public int mincostTickets(int[] days, int[] costs) {
        int dp[][]=new int[days.length][396];
        for(int edge[]:dp){
            Arrays.fill(edge,-1);
        }
        int res= min_cost(days,costs,0,0,dp);
        return res;
    }
}