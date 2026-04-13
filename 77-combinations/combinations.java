class Solution {
    public void back(List<List<Integer>>res,int n,int k,int start,List<Integer> list){
        if(k==0){
            res.add(new ArrayList<>(list));
            return; 
        }
        for(int i=start;i<=n;i++){
            list.add(i);
            back(res,n,k-1,i+1,list);
            list.remove(list.size()-1);
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans=new ArrayList<>();
        back(ans,n,k,1,new ArrayList<>());
        return ans;
    }
}