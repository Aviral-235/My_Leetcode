class Solution {
    public int[][] divideArray(int[] nums, int k) {
        int ans[][]=new int[nums.length/3][3];
        Arrays.sort(nums);
        int l=0;
        for(int i=0;i<nums.length-2;i+=3){
            int arr[] =new int[3];
            if(nums[i+2]-nums[i]<=k){
                for(int j=i;j<=i+2;j++){
                    arr[j-i]=nums[j];
                }
            }
            else{
                int temp[][]=new int[0][0];
                return temp;
            }
                ans[l]=arr;
                l++;
        }
        return ans;
    }
}