class Solution {
    public int profit(int arr[],int i,int buy,int k,int dp[][][]){
        if(k==0){
            return 0;
        }
        if(i==arr.length){
            return 0;
        }
        if(dp[i][buy][k]!=-1){
            return dp[i][buy][k];
        }
        else{
              if(buy==0){
                  int take=-arr[i]+profit(arr,i+1,1,k,dp);
                  int not_take=profit(arr,i+1,0,k,dp);
                  return dp[i][buy][k]=Math.max(take,not_take);
              } 
                  int take=arr[i]+profit(arr,i+1,0,k-1,dp);
                  int not_take=profit(arr,i+1,1,k,dp);
                  return dp[i][buy][k]=Math.max(take,not_take);
        }
        
    }
    public int maxProfit(int k, int[] prices) {
        int dp[][][]=new int[prices.length][2][k+1];
        for(int matrix[][]:dp){
            for(int row[]:matrix){
                Arrays.fill(row,-1);
            }
        }
        return profit(prices,0,0,k,dp);
    }
}