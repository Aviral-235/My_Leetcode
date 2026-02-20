class Solution {
    public int[][] sortMatrix(int[][] grid) {
        List<Integer> temp=new ArrayList<>();
        int n=grid.length;
        for(int i=0;i<n;i++){
            temp.add(grid[i][i]);
        }
        Collections.sort(temp);
        Collections.reverse(temp);
        for(int i=0;i<n;i++){
            grid[i][i]=temp.get(i);
        }
        for(int k=1;k<n;k++){
            int i=k;
            int j=0;
            List<Integer> temp2=new ArrayList<>();
            while(i<n&&j<n){
                temp2.add(grid[i][j]);
                i++;
                j++;
            }
            Collections.sort(temp2);
            Collections.reverse(temp2);
            i=k;
            j=0;
            int ind=0;
            while(i<n&&j<n){
                grid[i][j]=temp2.get(ind);
                ind++;
                i++;
                j++;
            }
        }
             for(int k=1;k<n;k++){
            int i=0;
            int j=k;
            List<Integer> temp2=new ArrayList<>();
            while(i<n&&j<n){
                temp2.add(grid[i][j]);
                i++;
                j++;
            }
            Collections.sort(temp2);
            // Collections.reverse(temp2);
            i=0;
            j=k;
            int ind=0;
            while(i<n&&j<n){
                grid[i][j]=temp2.get(ind);
                ind++;
                i++;
                j++;
            }
        }
        return grid;

    }
}