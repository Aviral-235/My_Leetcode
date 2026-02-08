class Solution {
    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);
        int max_count=1;
        int res=0;
        int j=0;
        for(int i=0;i<nums.length;i++){
            while(j<nums.length&&(long)nums[i]*k>=(long)nums[j]){
                j++;
            }
            max_count= j-i;
            res=Math.max(max_count,res);
        }
        return nums.length-res;
    }
}