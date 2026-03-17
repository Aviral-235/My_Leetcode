class Solution {
    public int lengthOfLIS(int[] nums) {
        int lis[]=new int[nums.length];
        lis[0]=1;
        for(int i=0;i<nums.length;i++){
            lis[i]=1;
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    lis[i]=Math.max(lis[i],1+lis[j]);
                }
            }
        }
            int res=0;
            for(int i=0;i<lis.length;i++){
                if(lis[i]>res){
                    res=lis[i];
                }
            }
        return res;
    }
}