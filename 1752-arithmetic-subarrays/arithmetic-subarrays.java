import java.util.*;
class Solution {
    public static boolean check(List<Integer> list){
        if(list.size()==2){
            return true;
        }
        int diff= list.get(1)-list.get(0);
        for(int i=2;i<list.size();i++){
            if(list.get(i)-list.get(i-1)!=diff){
                return false;
            }
        }
        return true;
    }
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> ans=new ArrayList<>();
        for(int i=0;i<l.length;i++){
            ArrayList<Integer> list=new ArrayList<>();
            for(int j=l[i];j<=r[i];j++){
                list.add(nums[j]);
            }
            Collections.sort(list);
            ans.add(check(list));
        }
        return ans;
    }
}