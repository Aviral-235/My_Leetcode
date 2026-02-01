import java.util.*;
class Solution {
    public int minimumCost(int[] nums) {
        int sum=nums[0];
        nums[0]=Integer.MAX_VALUE;
        Arrays.sort(nums);
        sum+=nums[0]+nums[1];
        return sum;
    }
}