class Solution {
    public int profit(int arr[],int i,int buy,int dp[][]){
        if(i>=arr.length){
            return 0;
        }
        if(dp[i][buy]!=-1){
            return dp[i][buy];
        }
        else{
        if(buy==0){
            int take= -arr[i]+profit(arr,i+1,1,dp);
            int not_take=profit(arr,i+1,0,dp);
            return dp[i][buy]= Math.max(take,not_take);
        }
            int take=arr[i]+profit(arr,i+2,0,dp);
            int not_take=profit(arr,i+1,1,dp);
            return dp[i][buy]=Math.max(take,not_take);
        
        }
    }
    public int maxProfit(int[] prices) {
        int dp[][]=new int[prices.length][2];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        return profit(prices,0,0,dp);
    }
}