import java.util.*;
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
         int res=nums[0]+nums[1]+nums[2];
         int sum=0;
        for(int i=0;i<nums.length-2;i++){
            int j= i+1;
            int last= nums.length-1;
            
            while(j<last){
               sum= nums[i]+nums[j]+nums[last];
               if(Math.abs(target-sum)<Math.abs(target-res)){
                res=sum;
               }
               if(sum==target){
                return sum;
               }
               else if(sum<target){
                j++;
                
               } else{
                last--;
               }
            }
        }
        return res;
    }
}