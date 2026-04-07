class Solution {
    public int paths(int grid[][],int m,int n,int[][]dp){
        if(dp[m][n]!=-1){
            return dp[m][n];
        }
        else{
        if(m==grid.length-1&&n==grid[0].length-1){
            return 1;
        }
        if(m>grid.length-1||n>grid[0].length-1){
            return 0;
        }
        if(grid[m][n]==1){
            return 0;
            }
        }
        return dp[m][n]=paths(grid,m+1,n,dp)+paths(grid,m,n+1,dp);
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1 || obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1] == 1) {
            return 0;
        }
        int dp[][]=new int[obstacleGrid.length+1][obstacleGrid[0].length+1];
        for(int edge[]:dp){
            Arrays.fill(edge,-1);
        }
        return paths(obstacleGrid,0,0,dp);
    }
}