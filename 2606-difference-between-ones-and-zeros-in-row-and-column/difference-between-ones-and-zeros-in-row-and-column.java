class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int one_rows[]=new int[m];
        int zero_rows[]=new int[m];
        int one_cols[]=new int[n];
        int zero_cols[]=new int[n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    zero_rows[i]++;
                }
                else{
                    one_rows[i]++;
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[j][i]==0){
                    zero_cols[i]++;
                }
                else{
                    one_cols[i]++;
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                grid[i][j]=one_rows[i]+one_cols[j]-zero_rows[i]-zero_cols[j];
            }
        }
        return grid;
    }
}