import java.util.*;
class Solution {
    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        int count=0;
        int res[]=new int[queries.length];
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]==x){
                count++;
                list.add(i);
            }
        }
        for(int i=0;i<queries.length;i++){
            if(queries[i]>count){
                res[i]=-1;
                continue;
            }
                res[i]=list.get(queries[i]-1);
            }
        
        return res;
    }
}