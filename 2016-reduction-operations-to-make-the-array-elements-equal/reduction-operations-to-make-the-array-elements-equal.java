import java.util.*;
class Solution {
    public static int second_largest(int arr[]){
        int j=arr.length-2;
        while(j>=0&&arr[j]==arr[j+1] ){
            j--;
        }
        if(j==-1){
            return -1;
        }
        return arr[j];
    }
    public int reductionOperations(int[] nums) {
        Arrays.sort(nums);
        int ans=0;
       int count=0;
            for(int i=1;i<nums.length;i++){
                if(nums[i-1]!=nums[i]){
                    count++;
                }
                ans+=count;
            }
        
      return ans;
    }
}