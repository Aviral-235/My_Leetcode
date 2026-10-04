class Solution {
    public boolean checkValidString(String s) {
        
        Boolean dp[][]=new Boolean[s.length()][s.length()];
        return solve(s,0,0,dp);
        
    }
    public boolean solve(String s,int inner,int idx,Boolean dp[][]){
            if(inner<0){
                return false;
            }
            if(idx==s.length()){
                return inner==0;
            }
            if(dp[inner][idx]!=null){
                return dp[inner][idx];
            }
            char c=s.charAt(idx);
            if(c=='('){
                return dp[inner][idx]=solve(s,inner+1,idx+1,dp);
            }
            else if(c==')'){
                return dp[inner][idx]=solve(s,inner-1,idx+1,dp);
            }
            return dp[inner][idx]=solve(s,inner,idx+1,dp)||solve(s,inner+1,idx+1,dp)||solve(s,inner-1,idx+1,dp);
    }
}