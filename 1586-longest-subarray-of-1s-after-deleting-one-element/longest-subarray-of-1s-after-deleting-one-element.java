class Solution {
    public int longestSubarray(int[] nums) {
        int count=0;
        int j=0;
        int zero_ct=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                zero_ct++;
            }
            if(zero_ct>1){
                count=Math.max(count,i-j-1);
                while(zero_ct>1){
                    if(nums[j]==0){
                        zero_ct--;
                    }
                    j++;
                }
            }
        }
        if(zero_ct==0){
            return nums.length-1;
        }
        else if(zero_ct==1){
            count=Math.max(count,nums.length-1-j);
        }
        else{
            count=Math.max(count,nums.length-1-j-1);
        }
        return count;
    }
}