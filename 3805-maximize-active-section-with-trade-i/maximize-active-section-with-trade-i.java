class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int totalOnes = 0;
        int maxZeroGain = 0;
        int prevZeroLen = -100000;
        
        int n = s.length();
        int i = 0;
        
        while (i < n) {
            int j = i;
            while (j < n && s.charAt(j) == s.charAt(i)) {
                j++;
            }
            
            int len = j - i;
            
            if (s.charAt(i) == '1') {
                totalOnes += len;
            } else {
                
                maxZeroGain = Math.max(maxZeroGain, prevZeroLen + len);
                prevZeroLen = len;
            }
            
            i = j;
        }
        
        return totalOnes + maxZeroGain;
    }
}