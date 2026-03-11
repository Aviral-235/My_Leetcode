class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int ans[][]=new int[n][n];
        for(int i=0;i<queries.length;i++){
            int row_s=queries[i][0];
            int col_s=queries[i][1];
            int row_e=queries[i][2];
            int col_e=queries[i][3];
            for(int j=row_s;j<=row_e;j++){
                for(int k=col_s;k<=col_e;k++){
                    ans[j][k]++;
                }
            }
        }
        return ans;
    }
}