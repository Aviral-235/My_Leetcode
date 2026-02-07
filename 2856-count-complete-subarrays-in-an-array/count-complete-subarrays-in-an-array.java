import java.util.*;
class Solution {
    public int countCompleteSubarrays(int[] nums) {
        Set<Integer> set=new HashSet<>();
        int count=0;
        for(int x: nums){
            set.add(x);
        }
        for(int i=0;i<nums.length;i++){
            Set<Integer> temp=new HashSet<>();
            for(int j=i;j<nums.length;j++){
                temp.add(nums[j]);
                if(temp.size()==set.size()){
                    count+=nums.length-j;
                    break;
                }
            }
        }
        return count;
    }
}