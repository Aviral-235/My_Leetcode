class Solution {
    public int matrixScore(int[][] grid) {
        for(int i=0;i<grid.length;i++){
            if(grid[i][0]==0){
                flip_row(grid,i);
            }
        }
        for(int j=0;j<grid[0].length;j++){
            int count_1=0;
            int count_0=0;
            for(int i=0;i<grid.length;i++){
                if(grid[i][j]==1){
                    count_1++;
                }
                else{
                    count_0++;
                }      
            }
                if(count_1<count_0){
                    flip_col(grid,j);
                }
        }
        int score=0;
        for(int i=0;i<grid.length;i++){
            int rowNum=0;
            int idx=0;
            for(int j=grid[0].length-1;j>=0;j--){
                rowNum+=(int)(Math.pow(2,idx)*grid[i][j]);
                idx++;
            }
            score+=rowNum;
        }
        return score;
    }
    public void flip_row(int grid[][],int row){
        for(int j=0;j<grid[0].length;j++){
            if(grid[row][j]==1){
                grid[row][j]=0;
            }
            else{
                grid[row][j]=1;
            }

        }
    }
    public void flip_col(int grid[][],int col){
        for(int i=0;i<grid.length;i++){
            if(grid[i][col]==1){
                grid[i][col]=0;
            }
            else{
                grid[i][col]=1;
            }
            
        }
    }
}