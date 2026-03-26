class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
            if(grid[0][0]!=0||grid[grid.length-1][grid[0].length-1]!=0){
                return -1;
            }
            if(grid.length==1){
                return 1;
            }
            Queue<int[]> q=new LinkedList<>();
            q.add(new int[]{0,0,1});
            int dirc[][]={{0,1},{0,-1},{1,0},{-1,0},{1,1},{-1,1},{1,-1},{-1,-1}};
            while(q.isEmpty()==false){
                int curr[]=q.poll();
                int r=curr[0];
                int c=curr[1];
                int dist=curr[2];
                for(int dir[]:dirc){
                    int r_=r+dir[0];
                    int c_=c+dir[1];
                    if(r_>=0&&r_<grid.length&&c_>=0&&c_<grid[0].length&&grid[r_][c_]==0){
                        
                        grid[r_][c_]=1;
                        if(r_==grid.length-1&&c_==grid[0].length-1){
                            return dist+1;
                        }
                        q.add(new int[]{r_,c_,dist+1});
                    }
                    
                }
            }
            return -1;
            }
        }
        