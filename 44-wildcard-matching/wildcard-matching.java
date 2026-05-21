import java.util.Arrays;

class Solution {
    public boolean checker(int n, int m, String s1, String s2, Boolean dp[][]) {
        if (n < 0 && m < 0) {
            return true;
        }
        if (m < 0 && n >= 0) {
            return false;
        }
        if (m >= 0 && n < 0) {
            for (int i = 0; i <= m; i++) {
                if (s2.charAt(i) != '*') {
                    return false;
                }
            }
            return true;
        }

        if (dp[n][m] != null) {
            return dp[n][m];
        } else {
            if (s1.charAt(n) == s2.charAt(m) || s2.charAt(m) == '?') {
                return dp[n][m] = checker(n - 1, m - 1, s1, s2, dp);
            }
            if (s2.charAt(m) == '*') {
                return dp[n][m] = checker(n - 1, m, s1, s2, dp) || checker(n, m - 1, s1, s2, dp);
            }
            return dp[n][m] = false;
        }
    }

    public boolean isMatch(String s, String p) {
        if (p.length() == 0) return s.length() == 0;
        if (s.length() == 0) {
            for (int i = 0; i < p.length(); i++) {
                if (p.charAt(i) != '*') return false;
            }
            return true;
        }

        Boolean dp[][] = new Boolean[s.length()][p.length()];
        
        return checker(s.length() - 1, p.length() - 1, s, p, dp);
    }
}