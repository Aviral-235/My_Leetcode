class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        int[] map = new int[128];
        for (char c : t.toCharArray()) {
            map[c]++;
        }

        int l = 0, r = 0;
        int count = 0;
        int minLen = Integer.MAX_VALUE;
        int sIdx = -1;

        while (r < s.length()) {
            char rightChar = s.charAt(r);
            if (map[rightChar] > 0) {
                count++;
            }
            map[rightChar]--;

            while (count == t.length()) {
                int len = r - l + 1;
                if (len < minLen) {
                    minLen = len;
                    sIdx = l;
                }

                char leftChar = s.charAt(l);
                map[leftChar]++;
                if (map[leftChar] > 0) {
                    count--;
                }
                l++;
            }
            r++;
        }

        return sIdx == -1 ? "" : s.substring(sIdx, sIdx + minLen);
    }
}