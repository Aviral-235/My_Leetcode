class Solution {
    public int longestSubsequence(int[] nums) {
        int ans=0;
        int ctZero=0;
        int xor=0;
        for(int i=0;i<nums.length;i++){
            xor^=nums[i];
            if(nums[i]==0){
                ctZero++;
            }
        }
        if(ctZero==nums.length){
            return 0;
        }
        if(xor==0){
            return nums.length-1;
        }
        return nums.length;
    }
}