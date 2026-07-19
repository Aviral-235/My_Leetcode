class Solution {
    public String removeDuplicateLetters(String s) {
        int[] last_idx = new int[26];
        for (int i = 0; i < s.length(); i++) {
            last_idx[s.charAt(i) - 'a'] = i;
        }
        
        boolean[] visited = new boolean[26];
        Stack<Character> st = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            
            if (visited[curr - 'a']) {
                continue;
            }
            
            while (!st.isEmpty() && st.peek() > curr && last_idx[st.peek() - 'a'] > i) {
                char removed = st.pop();
                visited[removed - 'a'] = false;
            }
            
            st.push(curr);
            visited[curr - 'a'] = true;
        }
        
        StringBuilder str = new StringBuilder();
        while (!st.isEmpty()) {
            str.append(st.pop());
        }
        
        return str.reverse().toString();
    }
}