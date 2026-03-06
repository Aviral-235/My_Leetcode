import java.util.*;
class Solution {
    public int minSteps(String s, String t) {
        Map<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        int swap=0;
        for(int i=0;i<t.length();i++){
            if(map.containsKey(t.charAt(i))){
                    map.computeIfPresent(t.charAt(i), (key, val) -> val > 1 ? val - 1 : null);
                }
                else{
                    swap++;
                }
            }
        
        return swap;
    }
}