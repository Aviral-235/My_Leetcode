import java.util.*;
class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        Set<Integer> set=new HashSet<>();
        int ans[]=new int[2];
        int i=0;
        for(int number:nums){
            if(set.contains(number)){
                ans[i]=number;
                i++;
            }
            else{
                set.add(number);
            }
        }
        return ans;
    }
}