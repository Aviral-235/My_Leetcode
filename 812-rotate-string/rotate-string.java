class Solution {
    public boolean check_(int start,int end,String s1,String s2){
        for(int i=start;i<=end;i++){
            if(s1.charAt(i)!=s2.charAt(i-start)){
                return false;
            }
        }
        return true;
    }
    public boolean rotateString(String s, String goal) {
        if(s.length()!=goal.length()){
            return false;
        }
       String check=s+s;
       for(int i=0;i<=s.length();i++){
        if(check_(i,i+s.length()-1,check,goal)==true){
            return true;
        }
       }
       return false;
    }
}