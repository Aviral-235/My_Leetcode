class Solution {
    public static boolean ismatching(char a,char b){
        if(a=='('&&b==')'||a=='{'&&b=='}'||a=='['&&b==']'){
            return true;
        }
        return false;
    }
    public boolean isValid(String s) {
        Deque<Character>s1= new ArrayDeque<>();
        for(int i=0;i<s.length();i++){
            char x= s.charAt(i);
            if(x=='('||x=='{'||x=='['){
                s1.push(x);
            }
            else{
                if(s1.isEmpty()==true){
                    return false;
                }
                else if(ismatching(s1.peek(),x)==false){
                    return false;
                }
                else{
                    s1.pop();
                }
            }
        }
        return (s1.isEmpty()==true);
    }
}