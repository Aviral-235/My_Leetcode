class Solution {
    public int smallestIndex(int[] nums) {
        for(int i=0;i<nums.length;i++){
            if(sum(nums[i])==i){
                return i;
            }
        }
        return -1;
    }
    public int sum(int x){
        int ans=0;
        while(x>0){
            ans+=(x%10);
            x/=10;
        }
        return ans;
    }
}