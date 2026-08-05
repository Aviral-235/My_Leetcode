class Solution {
    public boolean search(int[] nums, int target) {
        int idx=0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]>nums[i+1]){
                idx=i+1;
                break;
            }
        }
        if(idx==0){
            return bs(nums,0,nums.length-1,target);
        }
        return (bs(nums,0,idx-1,target)||bs(nums,idx,nums.length-1,target));
    }
    public boolean bs(int nums[],int i,int j,int target){
        int l=i;
        int h=j;
        while(l<=h){
            int mid=(l+h)/2;
            if(nums[mid]==target){
                return true;
            }
            if(nums[mid]<target){
                l=mid+1;
            }
            else{
                h=mid-1;
            }
        }
        return false;
    }
}