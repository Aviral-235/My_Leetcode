class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer,Integer> mpp=new HashMap<>();
        int res=0;
        int currSum=0;
        mpp.put(0,1);
        for(int i=0;i<nums.length;i++){
          currSum+=nums[i];
          res+=mpp.getOrDefault(currSum-goal,0);
          mpp.put(currSum,mpp.getOrDefault(currSum,0)+1);
        }
        
        return res;
    }
}