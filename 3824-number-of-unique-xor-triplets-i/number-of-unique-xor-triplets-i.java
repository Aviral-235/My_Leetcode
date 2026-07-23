class Solution {
    public int uniqueXorTriplets(int[] nums) {
        Arrays.sort(nums);
        if(nums.length==1){
            return 1;
        }
        if(nums[nums.length-1]==2){
            return 2;
        }
        int x=1;
        while((int)Math.pow(2,x)<=nums[nums.length-1]){
            x++;
        }
        return (int)Math.pow(2,x);
    }
}