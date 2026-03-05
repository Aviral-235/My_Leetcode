import java.util.*;
class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        Set<Integer> set=new TreeSet<>();
        set.add(nums[0]);
        while(set.size()>0){
            set.clear();
            for(int i=0;i<nums.length;i++){
                if(nums[i]!=-1&&set.contains(nums[i])==false){
                    set.add(nums[i]);
                    nums[i]=-1;
                }
            }
            List<Integer> temp=new ArrayList<>(set);
            if(temp.size()>0){
            ans.add(temp);    
            }
        }
        return ans;
    }
}