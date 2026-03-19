class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int sum_x[]=new int[grid[0].length];
        int sum_y[]=new int[grid[0].length];
        int res=0;
        for(int i=0;i<grid.length;i++){
            int rx=0;
            int ry=0;
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='X'){
                    rx++;
                   }
                else if(grid[i][j]=='Y'){
                    ry++;
                    }
                 sum_x[j]+=rx;
                 sum_y[j]+=ry;
                if(sum_x[j]>0&&sum_x[j]==sum_y[j]){
                    res++;
                }
            }

        }
        return res;
    }
}