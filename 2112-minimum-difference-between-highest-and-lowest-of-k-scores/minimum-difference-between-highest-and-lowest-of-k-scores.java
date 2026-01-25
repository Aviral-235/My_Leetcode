import java.util.*;
class Solution {
    public int minimumDifference(int[] nums, int k) {
        if(k==1){
            return 0;
        }
        int res=Integer.MAX_VALUE;
        Arrays.sort(nums);
        int i=0;
        int j= k-1;
        while(j<nums.length){
            res=Math.min(res,nums[j]-nums[i]);
            j++;
            i++;
        }
        return res;
    }
}