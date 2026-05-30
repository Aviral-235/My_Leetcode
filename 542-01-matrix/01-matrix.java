class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int dist[][]=new int[mat.length][mat[0].length];
        for(int row[]:dist){
            Arrays.fill(row,Integer.MAX_VALUE);
        }
        boolean visited[][]=new boolean[mat.length][mat[0].length];
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==0){
                    q.add(new int[]{i,j,0});
                    dist[i][j]=0;
                    visited[i][j]=true;
                }
            }
        }
             int dirc[][]={{0,1},{1,0},{-1,0},{0,-1}};
            while(q.isEmpty()==false){
                int curr[]=q.poll();
                int r=curr[0];
                int c=curr[1];
                int d=curr[2];
                for(int dir[]:dirc){
                    int rn=r+dir[0];
                    int cn=c+dir[1];
                    if(rn>=0&&rn<mat.length&&cn>=0&&cn<mat[0].length&&visited[rn][cn]==false){
                        dist[rn][cn]=d+1;
                        q.add(new int[]{rn,cn,d+1});
                        visited[rn][cn]=true;
                    }
                }
            }
        
        return dist;
    }
}