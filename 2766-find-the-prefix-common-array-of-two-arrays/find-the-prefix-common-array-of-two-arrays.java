import java.util.*;
class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int common_count=0;
        int ans[]=new int[A.length];
        int k=0;
        for(int i=0;i<A.length;i++){
            map.put(A[i],map.getOrDefault(A[i],0)+1);
            if(map.get(A[i])==2){
                common_count++;
            }
            map.put(B[i],map.getOrDefault(B[i],0)+1);
            if(map.get(B[i])==2){
               common_count++;
            }
            ans[k]=common_count;
            k++;
        }
        return ans;
    }
}