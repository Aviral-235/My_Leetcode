class Solution {
    public int jump(int[] nums) {
        if(nums.length==1){
            return 0;
        }
        int reach=0;
        int count=0;
        int curr=0;
        for(int i=0;i<nums.length;i++){
            if(i+nums[i]>reach){
                reach=i+nums[i];
            }
            if(i==curr){
                curr=reach;
                count++;
            }
            if(curr>=nums.length-1){
                break;
            }
            }
            return count;
        }
        
    }
