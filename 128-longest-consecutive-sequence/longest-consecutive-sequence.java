class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        Arrays.sort(nums);
        int longest=0;
        int count=0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i+1]==nums[i]+1){
                count++;
            }
            else if(nums[i+1]==nums[i]){
                continue;
            }
            else{
                longest=Math.max(longest,count+1);
                count=0;
            }
        }
        longest=Math.max(longest,count+1);
        return longest;
    }
}