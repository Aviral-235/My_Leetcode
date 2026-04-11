class Solution {
    public int minpath(int grid[][],int n,int target,int sum,int dp[][ ]){
        if(n<0){
            return Math.abs(target-sum);
        }
        if(dp[n][sum]!=-1){
            return dp[n][sum];
        }
        else{
        int mindiff=Integer.MAX_VALUE;
        for(int col=0;col<grid[0].length;col++){
            int res=minpath(grid,n-1,target,sum+grid[n][col],dp);
            mindiff=Math.min(mindiff,res);
        }
        return dp[n][sum]=mindiff;
        }
    }
    public int minimizeTheDifference(int[][] mat, int target) {
        int n=mat.length-1;
        int dp[][]=new int[n+1][4900];
        for(int edge[]:dp){
            Arrays.fill(edge,-1);
        }
        return minpath(mat,n,target,0,dp);
    }
}