import java.util.*;
class Solution {
    public int longestBalanced(int[] nums) {
        
        int res=0;
        for(int i=0;i<nums.length-1;i++){
            Set<Integer> set1=new HashSet<>();
        Set<Integer> set2=new HashSet<>();
            if(nums[i]%2==0){
                set1.add(nums[i]);
            }
            else{
                set2.add(nums[i]);
            }
                for(int j=i+1;j<nums.length;j++){
                     if(nums[j]%2==0){
                set1.add(nums[j]);
            }
            else{
                set2.add(nums[j]);
            }
            if(set1.size()==set2.size()){
                res=Math.max(res, j-i+1);
            }
                }
            
        }
        return res;
    }
}