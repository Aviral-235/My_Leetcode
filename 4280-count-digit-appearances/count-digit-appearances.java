class Solution {
    public int count(int n,int target){
        int count=0;
        while(n>0){
            int rem=n%10;
            if(rem==target){
                count++;
            }
            n/=10;
      }
      return count;
    }
    public int countDigitOccurrences(int[] nums, int digit) {
        int ans=0;
        for(int i=0;i<nums.length;i++){
            ans+=count(nums[i],digit);
        }
        return ans;
    }
}