class Solution {
    public int minimumDeletions(int[] nums) {
        int ll=Integer.MAX_VALUE;
        int rr=Integer.MAX_VALUE;
        int rl=Integer.MAX_VALUE;
        int lr=Integer.MAX_VALUE;
        int maxIdx=0;
        int minIdx=0;
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<min){
                min=nums[i];
                minIdx=i;
            }
            if(nums[i]>max){
                max=nums[i];
                maxIdx=i;
            }
        }
        ll=Math.max(minIdx+1,maxIdx+1);
        rr=Math.max(nums.length-minIdx,nums.length-maxIdx);
        rl=Math.min((nums.length-minIdx)+(maxIdx+1),(nums.length-maxIdx)+(minIdx+1));
        return Math.min(ll,Math.min(rr,rl));
    }
}