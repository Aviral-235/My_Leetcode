import java.util.*;
class Solution {
    public int minPairSum(int[] nums) {
        int res=0;
        Arrays.sort(nums);
        int i=0;
        int j=nums.length-1;
        while(i<j){
            res= Math.max(res,nums[i]+nums[j]);
            i++;
            j--;
        }
        return res;
    }
}