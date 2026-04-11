class Solution {
    public int minimumDistance(int[] nums) {
        int max = 0;
        int res = Integer.MAX_VALUE;

        // Find the max value
        for (int num : nums) {
            max = Math.max(max, num);
        }

        // Initialize the buckets
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= max; i++) {
            list.add(new ArrayList<>());
        }

        // Fill buckets with indices
        for (int i = 0; i < nums.length; i++) {
            list.get(nums[i]).add(i);
        }

        // Calculate distances
        for (int i = 0; i < list.size(); i++) {
            List<Integer> currentIndices = list.get(i);
            
            // Note: Use >= 3 to handle cases where a number appears 4+ times
            if (currentIndices.size() >= 3) {
                // If there are more than 3, you'd typically want 
                // the 3 closest ones (sliding window)
                for (int j = 0; j <= currentIndices.size() - 3; j++) {
                    int a = currentIndices.get(j);
                    int b = currentIndices.get(j + 1);
                    int c = currentIndices.get(j + 2);
                    
                    int dist = Math.abs(a - b) + Math.abs(a - c) + Math.abs(c - b);
                    res = Math.min(res, dist);
                }
            }
        }

        return (res == Integer.MAX_VALUE) ? -1 : res;
    }
}