class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int dp[][]=new int[matrix.length][matrix[0].length];
        for(int j=0;j<matrix[0].length;j++){
            dp[0][j]=matrix[0][j];
        }
        for(int i=1;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                int b=matrix[i][j]+dp[i-1][j];
                int l=Integer.MAX_VALUE;
                int r=Integer.MAX_VALUE;
                if(j>=1){
                    l=matrix[i][j]+dp[i-1][j-1];
                }
                if(j+1<matrix[0].length){
                    r=matrix[i][j]+dp[i-1][j+1];
                }
                dp[i][j]=Math.min(b,Math.min(l,r));
            }
        }
        int min=dp[matrix.length-1][0];
        for(int j=1;j<matrix[0].length;j++){
            min=Math.min(min,dp[matrix.length-1][j]);
        }
        return min;
    }

}