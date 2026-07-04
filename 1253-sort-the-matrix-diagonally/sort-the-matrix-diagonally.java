class Solution {
    public int[][] diagonalSort(int[][] mat) {
        for(int i=0;i<mat[0].length;i++){
            int r=0;
            int c=i;
            List<Integer> temp=new ArrayList<>();
            while(r<mat.length&&c<mat[0].length){
                temp.add(mat[r][c]);
                r++;
                c++;
            }
            Collections.sort(temp);
            r=0;
            c=i;
            int k=0;
             while(r<mat.length&&c<mat[0].length){
                mat[r][c]=temp.get(k);
                r++;
                c++;
                k++;
            }
        }
        for(int i=1;i<mat.length;i++){
            int r=i;
            int c=0;
            List<Integer> temp=new ArrayList<>();
            while(r<mat.length&&c<mat[0].length){
                temp.add(mat[r][c]);
                r++;
                c++;
            }
            Collections.sort(temp);
            r=i;
            c=0;
            int k=0;
             while(r<mat.length&&c<mat[0].length){
                mat[r][c]=temp.get(k);
                r++;
                c++;
                k++;
            }
        }
        return mat;
    }
}