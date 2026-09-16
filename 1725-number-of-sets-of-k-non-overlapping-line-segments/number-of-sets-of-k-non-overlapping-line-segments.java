class Solution {
    public int numberOfSets(int n, int k) {
        int dp[][][]=new int[n][k+1][2];
        for(int edge[][]:dp){
            for(int row[]:edge){
            Arrays.fill(row,-1);
            }
        }
        return dp(n,0,k,0,dp);
    }
    public int dp(int n,int idx,int k,int is_open,int dp[][][]){
        if(k==0){
            return 1;
        }
        if(k<0){
            return 0;
        }
        if(idx>=n){
            return 0;
        }
        if(dp[idx][k][is_open]!=-1){
            return dp[idx][k][is_open];
        }
        int take=0;
        int not_take=0;
        if(is_open==1){
             take=dp(n,idx+1,k,1,dp);
             not_take=dp(n,idx,k-1,0,dp);
       
        }
        if(is_open==0){
             take=dp(n,idx+1,k,1,dp);
             not_take=dp(n,idx+1,k,0,dp);
          
        }
        return dp[idx][k][is_open]=(take + not_take) % 1_000_000_007;
    }
}