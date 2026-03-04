class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int n=grid.length;
        int temp_sum=0;
        int []row_max=new int[n];
        int []col_max=new int[n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                temp_sum+=grid[i][j];
                row_max[i]=Math.max(row_max[i],grid[i][j]);
                col_max[i]=Math.max(col_max[i],grid[j][i]);

            }
        }
        int sum=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                sum+=Math.min(row_max[i],col_max[j]);
            }
        }
            return sum-temp_sum;
    }
}