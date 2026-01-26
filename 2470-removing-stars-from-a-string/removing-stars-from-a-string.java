class Solution {
    public static String reverseString(String input) {
    if (input == null) {
        return null;
    }
    return new StringBuilder(input).reverse().toString();
}
    public String removeStars(String s) {
        Deque<Character> st= new ArrayDeque<>();
         String res="";
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='*'){
                if(st.isEmpty()==true){
                    continue;
                }
                st.pop();
                continue;
            }
            st.push(s.charAt(i));
        }
       int n=st.size();
       for(int i=0;i<n;i++){
        res+=st.pop();
       }
        return reverseString(res);
    }
}