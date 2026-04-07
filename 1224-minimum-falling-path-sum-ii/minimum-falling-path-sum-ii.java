class Solution {
    public int min_(int grid[][],int n,int last,int memo[][]){
        if(memo[n-1][last]!=-1){
            return memo[n-1][last];
        }
        else{
        if(n==1){
            int min=Integer.MAX_VALUE;
            for(int i=0;i<grid[0].length;i++){
                if(i!=last){
                    min=Math.min(min,grid[0][i]);
                }
            }
            return memo[n-1][last]=min;
        }
        int min=Integer.MAX_VALUE;
        for(int i=0;i<grid[0].length;i++){
            if(i!=last){
                int points=grid[n-1][i]+min_(grid,n-1,i,memo);
                min=Math.min(min,points);
                }
            }
            return memo[n-1][last]=min;
        }
    }
    public int minFallingPathSum(int[][] grid) {
        int n=grid.length;
        int memo[][]=new int[n][grid[0].length+1];
        for(int mem[]:memo){
            Arrays.fill(mem,-1);
        }
        return min_(grid,n,grid[0].length,memo);
    }
}