class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int arr[]=new int[grid.length*grid[0].length];
        int k=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                arr[k]=grid[i][j]%12345;
                k++;
            }
        }
        int prefix[]=new int[arr.length];
        prefix[0]=1;
        int suffix[]=new int[arr.length];
        suffix[suffix.length-1]=1;
        int prod=1;
        for(int i=1;i<prefix.length;i++){
            prod=(prod*arr[i-1])%12345;
            prefix[i]=prod;
        }
        prod=1;
        for(int i=suffix.length-2;i>=0;i--){
            prod=(prod*arr[i+1])%12345;
            suffix[i]=prod;
        }
        k=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                grid[i][j]=(prefix[k]*suffix[k])%12345;
                k++;
            }
        }
        return grid;
    }
}