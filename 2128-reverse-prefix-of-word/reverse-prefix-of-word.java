class Solution {
    public String reversePrefix(String word, char ch) {
        int idx=-1;
        for(int i=0;i<word.length();i++){
            if(word.charAt(i)==ch){
                idx=i;
                break;
            }
        }
        if(idx==-1){
            return word;
        }
        String res="";
        Deque<Character> st= new ArrayDeque<>();
        for(int i=0;i<=idx;i++){
            st.push(word.charAt(i));
        }
        for(int i=0;i<=idx;i++){
            res+=st.pop();
        }
        for(int i=idx+1;i<word.length();i++){
            res+=word.charAt(i);
        }
        return res;
    }
}