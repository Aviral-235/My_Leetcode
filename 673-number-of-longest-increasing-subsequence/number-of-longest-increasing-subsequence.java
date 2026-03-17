class Solution {
    public int findNumberOfLIS(int[] nums) {
        int lis[]=new int[nums.length];
        int count[]=new int[nums.length];
        count[0]=1;
        lis[0]=1;
        for(int i=0;i<nums.length;i++){
            lis[i]=1;
            count[i]=1;
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    if(lis[i]==lis[j]+1){
                        count[i]+=count[j];
                    }
                    else if(lis[i]<lis[j]+1){
                        lis[i]=1+lis[j];
                        count[i]=count[j];
                    }
                }
            }
        }
            int idx=0;
            int res=0;
            for(int i=0;i<lis.length;i++){
                if(lis[i]>res){
                    res=lis[i];
                }
            }
            int count_=0;
            for(int i=0;i<nums.length;i++){
                if(lis[i]==res){
                    count_+=count[i];
                }
            }

            return count_;
    }
}