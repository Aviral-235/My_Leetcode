class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int arr[]=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            int j=(i+1)%nums.length;
            boolean flag=false;
            while(j!=i){
                if(nums[j]>nums[i]){
                    arr[i]=nums[j];
                    flag=true;
                    break;
                }
                j=(j+1)%nums.length;
            }
            if(flag==false){
                arr[i]=-1;
            }
        }
        return arr;
    }
}