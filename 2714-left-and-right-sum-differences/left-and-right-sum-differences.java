class Solution {
    public int[] leftRightDifference(int[] nums) {
        int prefix[]=new int[nums.length];
        prefix[0]=0;
        int sum=0;
        for(int i=1;i<nums.length;i++){
            sum+=nums[i-1];
            prefix[i]=sum;
        }
        sum=0;
        int suffix[]=new int[nums.length];
        suffix[nums.length-1]=0;
        for(int i=nums.length-2;i>=0;i--){
            sum+=nums[i+1];
            suffix[i]=sum;
        }
        int ans[]=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            ans[i]=Math.abs(prefix[i]-suffix[i]);
        }
        return ans;
    }
}