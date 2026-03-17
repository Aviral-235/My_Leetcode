class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int sum[][]=new int[mat.length][mat[0].length];
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                for(int m=i-k;m<=i+k;m++){
                    for(int n=j-k;n<=j+k;n++){
                        if(m>=0&&m<mat.length&&n>=0&&n<mat[0].length){
                            sum[i][j]+=mat[m][n];
                        }
                    }
                }
            }
        }
        return sum;
    }
}