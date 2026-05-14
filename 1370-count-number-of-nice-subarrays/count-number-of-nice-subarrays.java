class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int res=0;
        int odds[]=new int[nums.length+1];
        odds[0]=1;
        int currentodds=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]%2!=0){
                currentodds++;
            }
            if(currentodds>=k){
                res+=odds[currentodds-k];
            }
            odds[currentodds]++;
        }
        return res;
    }
}