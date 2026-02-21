class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans = new ArrayList<>();
        for (String word : words) {
            if (matches(word, pattern)) {
                ans.add(word);
            }
        }
        return ans;
    }

    private boolean matches(String word, String pattern) {
        // Use arrays of size 256 for basic ASCII character mapping
        int[] mapW = new int[256];
        int[] mapP = new int[256];

        for (int i = 0; i < word.length(); i++) {
            char w = word.charAt(i);
            char p = pattern.charAt(i);

            // If we haven't seen these characters yet, record the mapping
            if (mapW[w] == 0 && mapP[p] == 0) {
                mapW[w] = p;
                mapP[p] = w;
            } 
            // If the current character doesn't match the recorded mapping, fail
            else if (mapW[w] != p || mapP[p] != w) {
                return false;
            }
        }
        return true;
    }
}