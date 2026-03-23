class Solution {
    int maxsum(int nums[],int start,int end){
        int n=end-start+1;
        if(n==1){
            return nums[start];
        }
        int dp[]=new int[n+1];
        dp[1]=nums[start];
        dp[2]=Math.max(nums[start],nums[start+1]);
        for(int i=3;i<n+1;i++){
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[start+i-1]);
        }
        return dp[n];
    }
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1){
            return nums[0];
        }
        if(n==2){
            return Math.max(nums[0],nums[1]);
        }
        return Math.max(maxsum(nums,0,n-2),maxsum(nums,1,n-1));
    }
}