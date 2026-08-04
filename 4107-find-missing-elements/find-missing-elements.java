import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> list = new ArrayList<>();
        if (nums == null || nums.length < 2) {
            return list;
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 1; i++) {
            // Fill in any numbers missing between nums[i] and nums[i+1]
            int current = nums[i];
            int next = nums[i + 1];

            // Ignore duplicate values in nums
            for (int missing = current + 1; missing < next; missing++) {
                list.add(missing);
            }
        }

        return list;
    }
}