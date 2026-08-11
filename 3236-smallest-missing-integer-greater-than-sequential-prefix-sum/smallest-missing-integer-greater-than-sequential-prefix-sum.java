class Solution {
    public int missingInteger(int[] nums) {
        int x=0;
        int curr=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]-1!=nums[i-1]){
                x=Math.max(curr,x);
                break;
            }
            else{
                curr+=nums[i];
            }
        }
        x=Math.max(curr,x);
        Arrays.sort(nums);
        for(int c:nums){
            if(c==x){
                x++;
            }
        }
        return x;
    }
}