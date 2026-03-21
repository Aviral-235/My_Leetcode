class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        for(int i=0;i<k/2;i++){
            for(int j=y;j<(y+k);j++){
                int row=x+i;
                int row2=x+k-i-1;
                int temp=grid[row][j];
                grid[row][j]=grid[row2][j];
                grid[row2][j]=temp;
            }
        }
        return grid;
    }
}