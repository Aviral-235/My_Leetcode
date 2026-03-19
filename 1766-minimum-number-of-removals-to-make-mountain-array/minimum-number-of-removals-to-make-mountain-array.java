class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int lcs[]=new int[nums.length];
        lcs[0]=1;
        for(int i=1;i<nums.length;i++){
            lcs[i]=1;
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    lcs[i]=Math.max(lcs[i],lcs[j]+1);
                }
            }
        }
        int lds[]=new int[nums.length];
        lds[nums.length-1]=1;
        for(int i=nums.length-2;i>=0;i--){
            lds[i]=1;
            for(int j=nums.length-1;j>i;j--){
                if(nums[i]>nums[j]){
                    lds[i]=Math.max(lds[i],lds[j]+1);
                }
            }
        }
        int res=0;
        for(int i=0;i<nums.length;i++){
            if(lds[i]>1&&lcs[i]>1)
            res=Math.max(res,lds[i]+lcs[i]-1);
        }
        return nums.length-res;
    }
}