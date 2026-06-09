import java.util.*;

class Solution {
    String b;
    HashMap<String, Integer> mpp;
    List<List<String>> ans;

    private void dfs(String word, List<String> seq) {
        if (word.equals(b)) {
            List<String> dup = new ArrayList<>(seq);
            Collections.reverse(dup);
            ans.add(dup);
            return;
        }

        int steps = mpp.get(word);
        int sz = word.length();
        for (int i = 0; i < sz; i++) {
            char replacedCharArray[] = word.toCharArray();
            for (char ch = 'a'; ch <= 'z'; ch++) {
                char original = replacedCharArray[i];
                replacedCharArray[i] = ch;
                String replacedWord = new String(replacedCharArray);

                if (mpp.containsKey(replacedWord) && mpp.get(replacedWord) + 1 == steps) {
                    seq.add(replacedWord);
                    dfs(replacedWord, seq);
                    seq.remove(seq.size() - 1);
                }
                replacedCharArray[i] = original;
            }
        }
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> st = new HashSet<>(wordList);
        if (!st.contains(endWord)) return new ArrayList<>();

        Queue<String> q = new LinkedList<>();
        b = beginWord;
        q.add(beginWord);

        mpp = new HashMap<>();
        mpp.put(beginWord, 1);
        int sizee = beginWord.length();
        st.remove(beginWord);

        List<String> usedOnLevel = new ArrayList<>();
        boolean foundEnd = false;

        while (!q.isEmpty()) {
            int levelSize = q.size();

            for (int k = 0; k < levelSize; k++) {
                String word = q.peek();
                int steps = mpp.get(word);
                q.remove();

                if (word.equals(endWord)) {
                    foundEnd = true;
                }

                for (int i = 0; i < sizee; i++) {
                    char replacedCharArray[] = word.toCharArray();
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        replacedCharArray[i] = ch;
                        String replacedWord = new String(replacedCharArray);

                        if (st.contains(replacedWord)) {
                            if (!mpp.containsKey(replacedWord)) {
                                q.add(replacedWord);
                                mpp.put(replacedWord, steps + 1);
                                usedOnLevel.add(replacedWord);
                            }
                        }
                    }
                }
            }

            if (foundEnd) break;

            for (String s : usedOnLevel) {
                st.remove(s);
            }
            usedOnLevel.clear();
        }

        ans = new ArrayList<>();
        if (mpp.containsKey(endWord)) {
            List<String> seq = new ArrayList<>();
            seq.add(endWord);
            dfs(endWord, seq);
        }

        return ans;
    }
}