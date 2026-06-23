class Solution {
    List<String> ans=new ArrayList<>();
    StringBuilder s= new StringBuilder();
    public void backtrack(int idx,int n,int cost,int is_one){
        if(idx==n){
            if(cost>=0){
                ans.add(s.toString());
            }
            return;
        }
        if(cost<0){
            return;
        }
        if(is_one==-1){
            s.append('1');
            backtrack(idx+1,n,cost-idx,1);
            s.deleteCharAt(s.length()-1);
            s.append('0');
            backtrack(idx+1,n,cost,-1);
            s.deleteCharAt(s.length()-1);
        }
        else{
            s.append('0');
            backtrack(idx+1,n,cost,-1);
            s.deleteCharAt(s.length()-1);
        }
        
    }
    public List<String> generateValidStrings(int n, int k) {
        backtrack(0,n,k,-1);
        return ans;
    }
}