import java.util.*;
class Solution {
    public boolean doesAliceWin(String s) {
        Set<Character> set=new HashSet<>();
        int count=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='a'||s.charAt(i)=='e'||s.charAt(i)=='i'||s.charAt(i)=='o'||s.charAt(i)=='u'){
                set.add(s.charAt(i));
            }
        }
        count= set.size();
        if(count==0){
            return false;
        }
        
        return true;
    }
}