class Solution {
    public void nextPermutation(int[] nums) {
        int idx=-1;
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i+1]>nums[i]){
                idx=i;
                break;
            }
        }
        if(idx==-1){
            reverse(nums,0,nums.length);
        }
        else{
        for(int i=nums.length-1;i>idx;i--){
            if(nums[i]>nums[idx]){
                int temp=nums[i];
                nums[i]=nums[idx];
                nums[idx]=temp;
                break;
            }
        }
        reverse(nums,idx+1,nums.length);
        }
    }
    void reverse(int[] arr, int fromIndex, int toIndex) {
    int left = fromIndex;
    int right = toIndex - 1;

    while (left < right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
        left++;
        right--;
    }
}
}