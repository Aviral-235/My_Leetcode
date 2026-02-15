class Solution {
    public long[] findPrefixScore(int[] nums) {
        long conver[]=new long[nums.length];
        int max=0;
        for(int i=0;i<conver.length;i++){
            max=Math.max(max,nums[i]);
            conver[i]=nums[i]+max;
        }
        long ans[]=new long[nums.length];
        ans[0]=conver[0];
        for(int i=1;i<ans.length;i++){
            ans[i]=conver[i]+ans[i-1];
        }
        return ans;
    }
}