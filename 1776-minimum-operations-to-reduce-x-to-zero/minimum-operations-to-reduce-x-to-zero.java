class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];

        prefix[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }

        suffix[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + nums[i];
        }

        int minSteps = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (prefix[i] == x) {
                minSteps = Math.min(minSteps, i + 1);
            }
        }

        for (int i = 0; i < n; i++) {
            if (suffix[i] == x) {
                minSteps = Math.min(minSteps, n - i);
            }
        }

        int e = 1;
        for (int s = 0; s < n - 1; s++) {
            while (e < n && (s >= e || prefix[s] + suffix[e] > x)) {
                e++;
            }
            if (e < n && s < e && prefix[s] + suffix[e] == x) {
                minSteps = Math.min(minSteps, (s + 1) + (n - e));
            }
        }

        return minSteps == Integer.MAX_VALUE ? -1 : minSteps;
    }
}