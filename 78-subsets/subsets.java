import java.util.*;
class Solution {
    
    public static List<List<Integer>> helper(int [] nums,int idx,List<Integer> temp,List<List<Integer>> res){
        
        if(idx==nums.length){
            res.add(new ArrayList<>(temp));
            return res;
        }
        temp.add(nums[idx]);
        helper(nums,idx+1,temp,res);
        temp.remove(temp.size()-1);
        helper(nums,idx+1,temp,res);
        return res;
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res= new ArrayList<>();
      
        return helper(nums,0,new ArrayList<>(),res);
    }
}