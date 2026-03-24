class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        return dfs(image,sr,sc,image[sr][sc],color);
    }
    public static int[][] dfs(int grid[][],int r,int c,int original,int color){
        
        if(r>grid.length-1||r<0||c>grid[0].length-1||c<0||grid[r][c]!=original){
            return grid;
        }
        if(grid[r][c]==color){
            return grid;
        }
        grid[r][c]=color;
        dfs(grid,r+1,c,original,color);
        dfs(grid,r-1,c,original,color);
        dfs(grid,r,c+1,original,color);
        dfs(grid,r,c-1,original,color);
        return grid;
    }
}