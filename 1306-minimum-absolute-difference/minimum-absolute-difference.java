import java.util.*;
class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
       
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(arr);
        int mindiff= Integer.MAX_VALUE;
        for(int i=1;i<arr.length;i++){
            mindiff=Math.min(mindiff,arr[i]-arr[i-1]);
        }
        for(int i=1;i<arr.length;i++){
          
            if(arr[i]-arr[i-1]==mindiff){
                 List<Integer> temp=new ArrayList<>();
                temp.add(arr[i-1]);
                temp.add(arr[i]);
                ans.add(temp);
                
            }
            
        }
        return ans;
    }
}