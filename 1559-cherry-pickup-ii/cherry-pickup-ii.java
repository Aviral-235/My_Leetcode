class Solution {
    public static int cherri_cherri_lady(int[][]grid,int i,int j1,int j2,int dp[][][]){
        if(j1<0||j1>grid[0].length-1||j2<0||j2>grid[0].length-1){
            return -1_000_000_000;
        }
        if(dp[i][j1][j2]!=-1){
            return dp[i][j1][j2];
        }
        else{
        if(i==grid.length-1){
            if(j1==j2){
                return grid[i][j1];
            }
            else{
                return grid[i][j1]+grid[i][j2];
            }
        }
            int max=0;
            for(int d1=-1;d1<2;d1++){
                for(int d2=-1;d2<2;d2++){
                    int value=0;
                    if(j1==j2){
                        value=grid[i][j1];
                    }
                    else{
                        value=grid[i][j1]+grid[i][j2];
                    }
                    value+=cherri_cherri_lady(grid,i+1,j1+d1,j2+d2,dp);
                    max=Math.max(max,value);
                }
            }
            return dp[i][j1][j2]=max;
                }
        }
    
    public int cherryPickup(int[][] grid) {
        int dp[][][]=new int[grid.length][grid[0].length][grid[0].length];
        for(int outer[][]:dp){
            for(int inner[]:outer){
                Arrays.fill(inner,-1);
            }
        }
        return cherri_cherri_lady(grid,0,0,grid[0].length-1,dp);
    }
}