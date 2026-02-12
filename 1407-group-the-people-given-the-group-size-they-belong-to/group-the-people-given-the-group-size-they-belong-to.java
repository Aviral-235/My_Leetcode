import java.util.*;
class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
            List<List<Integer>> res=new ArrayList<>();
            for(int i=0;i<groupSizes.length;i++){
                List<Integer> temp=new ArrayList<>();
                if(groupSizes[i]==-1){
                    continue;
                }
                    temp.add(i);
                    
                    for(int j=i+1;j<groupSizes.length;j++){
                        if(groupSizes[i]==groupSizes[j]&&temp.size()<groupSizes[i]){
                            temp.add(j);
                            groupSizes[j]=-1;
                        }
                        if(temp.size()==groupSizes[i]){
                            break;
                        }
                    }
                    groupSizes[i]=-1;
                    res.add(temp);
            }
            return res;
            }
}