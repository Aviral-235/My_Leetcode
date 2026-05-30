class Solution {
    public int numEnclaves(int[][] grid) {
        boolean visited[][]=new boolean[grid.length][grid[0].length];
        int count=0;
        int count_1=0;
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if((i==0||i==grid.length-1||j==0||j==grid[0].length-1)&&grid[i][j]==1){
                    count++;
                    visited[i][j]=true;
                    q.add(new int[]{i,j});
                }
                if(grid[i][j]==1){
                    count_1++;
                }
            }
        }
        int dirc[][]={{0,1},{1,0},{0,-1},{-1,0}};
        while(q.isEmpty()==false){
            int curr[]=q.poll();
            int r=curr[0];
            int c=curr[1];
            for(int dir[]:dirc){
                int rn=r+dir[0];
                int cn=c+dir[1];
                if(rn>=0&&rn<grid.length&&cn>=0&&cn<grid[0].length){
                    if(visited[rn][cn]==false&&grid[rn][cn]==1){
                        count++;
                        visited[rn][cn]=true;
                        q.add(new int[]{rn,cn});
                    }
                }
            }
        }
        return count_1-count;
    }
}