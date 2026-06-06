class Solution {
    public int[] leftRightDifference(int[] nums) {
        int prefix[]=new int[nums.length];
        int suffix[]=new int[nums.length];
        int arr[]=new int[nums.length];
        prefix[0]=0;
        suffix[suffix.length-1]=0;
        for(int i=1;i<prefix.length;i++){
            prefix[i]=prefix[i-1]+nums[i-1];
        }
        for(int i=suffix.length-2;i>=0;i--){
            suffix[i]=suffix[i+1]+nums[i+1];
        }
        for(int i=0;i<nums.length;i++){
            arr[i]=Math.abs(prefix[i]-suffix[i]);
        }
        return arr;
    }
}