class Solution {
    public int findways(int[] arr,int n,int target,int dp[][]){
        if(n<0){
            if(target==0){
                return 1;
            }
            else{
                return 0;
            }
        }
        if(dp[n][target]!=-1){
            return dp[n][target];
        }
        else{
            int left=findways(arr,n-1,target,dp);
            int take=0;
            if(target>=arr[n]){
                take=findways(arr,n-1,target-arr[n],dp);
            }
            return dp[n][target]=left+take;
            }
        }
    public int findTargetSumWays(int[] nums, int target) {
        int sum=0;
        for(int x:nums){
            sum+=x;
        }
        if((sum+target)%2!=0){
            return 0;
        }
        int req_sum=(sum+Math.abs(target))/2;
        int n=nums.length-1;
        int dp[][]=new int[n+1][req_sum+1];
        for(int[]edge:dp){
            Arrays.fill(edge,-1);
        }
        return findways(nums,n,req_sum,dp);
    }
}