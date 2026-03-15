class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        if(nums.length==1){
            if(nums[0]>target){
                return 1;
            }
            return 0;
        }
        int left=0;
        int sum=0;
        int res=Integer.MAX_VALUE;
        for(int right=0;right<nums.length;right++){
            sum+=nums[right];
            while(sum>=target){
                res=Math.min(res,right-left+1);
                sum-=nums[left];
                left++;
            }

        }
        
        if(res==Integer.MAX_VALUE){
            return 0;
        }
        return res;
    }
}