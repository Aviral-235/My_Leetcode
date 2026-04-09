class Solution {
    public static int path(int grid[][],int n,int m,int dp[][]){
        if(m<0||m>grid[0].length-1){
            return Integer.MAX_VALUE;
        }
        if(dp[n][m]!=-1){
            return dp[n][m];
        }
        else{
        if(n==grid.length-1){
            return grid[n][m];
        }
        return dp[n][m]=grid[n][m]+Math.min(path(grid,n+1,m,dp),Math.min(path(grid,n+1,m+1,dp),path(grid,n+1,m-1,dp)));
        }
    }
    public int minFallingPathSum(int[][] matrix) {
        // int res=Integer.MAX_VALUE;
        // int dp[][]=new int[matrix.length][matrix[0].length];
        //     for(int edge[]:dp){
        //         Arrays.fill(edge,-1);
        //     }
        // for(int i=0;i<matrix[0].length;i++){ 
        //     int curr_res=path(matrix,0,i,dp);
        //     res=Math.min(res,curr_res);
        // }
        // return res;
        int dp[][]=new int[matrix.length][matrix[0].length];
        for(int j=0;j<matrix[0].length;j++){
            dp[0][j]=matrix[0][j];
        }
        for(int i=1;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                int b=matrix[i][j]+dp[i-1][j];
                int l=Integer.MAX_VALUE;
                int r=Integer.MAX_VALUE;
                if(j>=1){
                    l=matrix[i][j]+dp[i-1][j-1];
                }
                if(j+1<matrix[0].length){
                    r=matrix[i][j]+dp[i-1][j+1];
                }
                dp[i][j]=Math.min(b,Math.min(l,r));
            }
        }
        int min=dp[matrix.length-1][0];
        for(int j=1;j<matrix[0].length;j++){
            min=Math.min(min,dp[matrix.length-1][j]);
        }
        return min;
    }

}