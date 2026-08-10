class Solution {
    public int splitArray(int[] nums, int k) {
        int l = 0;
        int h = 0;
        for (int x : nums) {
            l = Math.max(l, x);
            h += x;
        }

        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (bs(nums, mid, k)) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public boolean bs(int[] arr, int maxSum, int k) {
        int count = 1;
        int currentSum = 0;

        for (int x : arr) {
            if (currentSum + x > maxSum) {
                count++;
                currentSum = x;
            } else {
                currentSum += x;
            }
        }

        return count <= k;
    }
}