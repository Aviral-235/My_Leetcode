class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int lis[]=new int[nums.length];
        int lds[]=new int[nums.length];
        lis[0]=1;
        for(int i=1;i<nums.length;i++){
            lis[i]=1;
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    lis[i]=Math.max(lis[i],1+lis[j]);
                }
            }
        }
        lds[nums.length-1]=1;
        for(int i=nums.length-2;i>=0;i--){
            lds[i]=1;
            for(int j=nums.length-1;j>i;j--){
                if(nums[i]>nums[j]){
                    lds[i]=Math.max(lds[i],1+lds[j]);
                }
            }
        }
        int max=0;
        for(int i=0;i<nums.length;i++){
            if(lds[i]+lis[i]>max&& lis[i]>1&&lds[i]>1){
                max=lds[i]+lis[i]-1;
            }
        }
        return nums.length-max;
    }
}