import java.util.*;
class Solution {
    public static boolean ismatching(char a,char b){
        if(a=='('&&b==')'){
            return true;
        }
        return false;
    }
    public int longestValidParentheses(String s) {
         Deque<Integer>s2= new ArrayDeque<>();
         s2.push(-1);
        int res=0;
        int temp=0;
        for(int i=0;i<s.length();i++){
            char x= s.charAt(i);
            if(x=='('){
                s2.push(i);
            }
            else{
                s2.pop();
                if(s2.isEmpty()==false){
                    res= Math.max(i-s2.peek(),res);
                }
                else{
                    s2.push(i);
                }
            }
        }
        return res;
    }
}