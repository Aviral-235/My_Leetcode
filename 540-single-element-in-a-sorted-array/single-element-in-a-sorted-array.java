class Solution {
    public int singleNonDuplicate(int[] nums) {
        if(nums.length==1) return nums[0];
        for(int i=1;i<nums.length-1;i++){
                if(nums[i-1]!=nums[i]&&nums[i+1]!=nums[i]){
                    return nums[i];
                }
        }
        if(nums[0]!=nums[1]){
            return nums[0];
        }
        return nums[nums.length-1];
    }
}