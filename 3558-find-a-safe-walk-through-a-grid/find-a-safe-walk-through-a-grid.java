class Solution {
    
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int dist[][]=new int[grid.size()][grid.get(0).size()];
        for(int rows[]:dist){
            Arrays.fill(rows,Integer.MAX_VALUE);
        }
        dist[0][0]=grid.get(0).get(0);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(dist[a[0]][a[1]], dist[b[0]][b[1]]));
        pq.add(new int[]{0,0});

        int dirc[][]={{0,1},{1,0},{-1,0},{0,-1}};
        
        while(pq.isEmpty()==false){
            int edge[]=pq.poll();
            int r=edge[0];
            int c=edge[1];
            if(r==grid.size()-1&&c==grid.get(0).size()-1){
                return dist[r][c]<health;
            }
            for(int dir[]:dirc){
                int nr=r+dir[0];
                int nc=c+dir[1];
                if(nr>=0&&nr<grid.size()&&nc>=0&&nc<grid.get(0).size()){
                    int wt=grid.get(nr).get(nc);
                if(wt+dist[r][c]<dist[nr][nc]){
                        dist[nr][nc]=wt+dist[r][c];
                        pq.add(new int[]{nr,nc});
                    }
                }
            }
        }
        return dist[grid.size()-1][grid.get(0).size()-1]<health;
    }
}