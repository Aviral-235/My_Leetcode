class Solution {
    public int orangesRotting(int[][] grid) {
        
        int count=0;
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    q.add(new int[]{i,j});
                }
                if(grid[i][j]==1){
                    count++;
                }
            }
        }
        if(count==0){
            return 0;
        }
            int dirc[][]={{1,0},{-1,0},{0,1},{0,-1}};
            int visited[][]=new int[grid.length][grid[0].length];
            int min=0;
            while(q.isEmpty()==false){
                int size=q.size();
                for(int i=0;i<size;i++){
                int curr[]=q.poll();
                int r=curr[0];
                int c=curr[1];
                for(int dir[]:dirc){
                    int nextr=r+dir[0];
                    int nextc=c+dir[1];
                    if(nextr>=0&&nextr<grid.length&&nextc>=0&&nextc<grid[0].length&&grid[nextr][nextc]==1){
                        grid[nextr][nextc]=2;
                        count--;
                        q.add(new int[]{nextr,nextc});
                    }

                    }
                }
                min++;
            }
            if(count>0){
                return -1;
            }
            return min-1;
    }
}