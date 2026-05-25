class Solution {
    public int profit(int arr[],int i,int buy,int fee,int dp[][]){
        if(i>=arr.length){
            return 0;
        }
        if(dp[i][buy]!=-1){
            return dp[i][buy];
        }
        else{
        if(buy==0){
            int take= -arr[i]+profit(arr,i+1,1,fee,dp);
            int not_take=profit(arr,i+1,0,fee,dp);
            return dp[i][buy]= Math.max(take,not_take);
        }
            int take=arr[i]+profit(arr,i+1,0,fee,dp)-fee;
            int not_take=profit(arr,i+1,1,fee,dp);
            return dp[i][buy]=Math.max(take,not_take);
        
        }
    }
    public int maxProfit(int[] prices, int fee) {
        int dp[][]=new int[prices.length][2];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        return profit(prices,0,0,fee,dp);
    }
}