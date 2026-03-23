class Solution {
    public int minCut(String s) {
        int n = s.length();
        if (n <= 1) return 0;

        boolean[][] isPal = new boolean[n][n];
        for (int gap = 0; gap < n; gap++) {
            for (int i = 0, j = gap; j < n; i++, j++) {
                if (gap == 0) {
                    isPal[i][j] = true;
                } else if (gap == 1) {
                    isPal[i][j] = (s.charAt(i) == s.charAt(j));
                } else {
                    isPal[i][j] = (s.charAt(i) == s.charAt(j) && isPal[i + 1][j - 1]);
                }
            }
        }

        int[] dp = new int[n];
        for (int j = 0; j < n; j++) {
            if (isPal[0][j]) {
                dp[j] = 0;
            } else {
                int min = j;
                for (int i = 0; i < j; i++) {
                    if (isPal[i + 1][j]) {
                        min = Math.min(min, dp[i] + 1);
                    }
                }
                dp[j] = min;
            }
        }

        return dp[n - 1];
    }
}