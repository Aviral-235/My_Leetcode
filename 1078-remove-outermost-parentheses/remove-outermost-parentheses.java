class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb=new StringBuilder();
        int ctOuter=0;
        int ctInner=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                if(ctOuter==0){
                    ctOuter++;
                    continue;
                }
                ctOuter++;
                sb.append('(');
            }
            else{
                ctInner++;
                if(ctInner==ctOuter){
                    ctInner=0;
                    ctOuter=0;
                    continue;
                }
                sb.append(')');
            }
        }
        return sb.toString();
    }
}