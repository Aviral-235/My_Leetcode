import java.util.Arrays;

class Solution {
    private final int MOD = 1_000_000_007;

    public int distinctSubseqII(String s) {
        int n = s.length();
        int[][] nextPos = new int[n + 1][26];
        Arrays.fill(nextPos[n], -1);

        for (int i = n - 1; i >= 0; i--) {
            for (int c = 0; c < 26; c++) {
                nextPos[i][c] = nextPos[i + 1][c];
            }
            nextPos[i][s.charAt(i) - 'a'] = i;
        }

        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);

        return dp(0, s, nextPos, memo);
    }

    private int dp(int idx, String s, int[][] nextPos, int[] memo) {
        if (memo[idx] != -1) {
            return memo[idx];
        }

        int count = 0;
        for (int c = 0; c < 26; c++) {
            int nextIdx = nextPos[idx][c];
            if (nextIdx != -1) {
                count = (count + 1 + dp(nextIdx + 1, s, nextPos, memo)) % MOD;
            }
        }

        return memo[idx] = count;
    }
}