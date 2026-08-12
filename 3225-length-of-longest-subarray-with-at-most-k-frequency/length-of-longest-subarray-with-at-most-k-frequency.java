class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        int maxLen=0;
        int j=0;
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            if(map.get(nums[i])>k){
                while(map.get(nums[i])>k){
                    map.put(nums[j],map.get(nums[j])-1);
                    j++;
                }
            }
            int len=i-j+1;
            maxLen=Math.max(maxLen,len);
        }
        return maxLen;
    }
}