class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int max=Integer.MIN_VALUE;
        int max_=Integer.MAX_VALUE;
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(sum>max){
                max=sum;
            }
            if(sum<0){
                sum=0;
            }
        }
        sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(sum<max_){
                max_=sum;
            }
            if(sum>0){
                sum=0;
            }
        }
        max_=Math.abs(max_);
        return Math.max(max,max_);
    }
}