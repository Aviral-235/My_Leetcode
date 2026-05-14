class Solution {
    public boolean isGood(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        if(nums[nums.length-1]!=n-1){
            return false;
        }
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]!=i+1){
                return false;
            }
        }
        return true;
    }
}