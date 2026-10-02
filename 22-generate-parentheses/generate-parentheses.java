class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans=new ArrayList<>();
        solve(n,new StringBuilder(),ans);
        return ans;
    }
    void solve(int n,StringBuilder sb,List<String> list){
        if(sb.length()==n*2){
            if(isValid(sb.toString())){
                list.add(sb.toString());
        }
            return;
            }
            sb.append('(');
            solve(n,sb,list);
            sb.deleteCharAt(sb.length()-1);
            sb.append(')');
            solve(n,sb,list);
             sb.deleteCharAt(sb.length()-1);
    }
    public boolean isValid(String s){
        int ctOpen=0;
        for(char c:s.toCharArray()){
            if(ctOpen<0){
                return false;
            }
            if(c=='('){
                ctOpen++;
            }
            else{
                ctOpen--;
            }
            
        }
        if(ctOpen>0) return false;
        return true;
    }
}