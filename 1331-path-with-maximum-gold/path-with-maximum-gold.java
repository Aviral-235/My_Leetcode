class Solution {
    public int max_gold(int grid[][],int row,int col,boolean visited[][]){
        if(row<0||row>grid.length-1||col<0||col>grid[0].length-1||grid[row][col]==0||visited[row][col]==true){
            return 0;
        }
        visited[row][col]=true;
        int up=max_gold(grid,row-1,col,visited);
        int down=max_gold(grid,row+1,col,visited);
        int right=max_gold(grid,row,col+1,visited);
        int left=max_gold(grid,row,col-1,visited);
        int max=Math.max(Math.max(up,down),Math.max(right,left));
            visited[row][col]=false;
            return grid[row][col]+max;
    }
    public int getMaximumGold(int[][] grid) {
        int res=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]!=0){
                    boolean visited[][]=new boolean[grid.length][grid[0].length];
                    res=Math.max(res,max_gold(grid,i,j,visited));
                }
            }
        }
        return res;
    }
}