import java.util.Arrays;

class Solution {
    public boolean winnerSquareGame(int n) {
        int[][] memo = new int[n + 1][2];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return problem(n, 0, memo);
    }

    public boolean problem(int n, int state, int[][] memo) {
        if (n == 0) {
            return state == 1;
        }

        if (memo[n][state] != -1) {
            return memo[n][state] == 1;
        }

        if (state == 0) {
            for (int i = 1; i * i <= n; i++) {
                if (problem(n - (i * i), 1, memo)) {
                    memo[n][state] = 1;
                    return true;
                }
            }
            memo[n][state] = 0;
            return false;
        } else {
            for (int i = 1; i * i <= n; i++) {
                if (!problem(n - (i * i), 0, memo)) {
                    memo[n][state] = 0;
                    return false;
                }
            }
            memo[n][state] = 1;
            return true;
        }
    }
}