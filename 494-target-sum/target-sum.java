class Solution {
    public int findways(int[] arr,int n,int target){
        if(n<0){
            if(target==0){
                return 1;
            }
            else{
                return 0;
            }
        }
        return findways(arr,n-1,target-arr[n])+findways(arr,n-1,target);
    }
    public int findTargetSumWays(int[] nums, int target) {
        int sum=0;
        for(int x:nums){
            sum+=x;
        }
        if((sum+target)%2!=0){
            return 0;
        }
        int req_sum=(sum+target)/2;
        int n=nums.length-1;
        return findways(nums,n,req_sum);
    }
}