class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int n=moveTime.length;
        int m=moveTime[0].length;
        int dist[][][]=new int[n][m][2];
        for(int row[][]:dist){
            for(int edge[]:row){
                Arrays.fill(edge,Integer.MAX_VALUE);
            }
        }
        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        dist[0][0][0]=0;
        pq.add(new int[]{0,0,0,0});
        int dirc[][]=new int[][]    {{1,0},{-1,0},{0,1},{0,-1}};
        while(pq.isEmpty()==false){
            int curr[]=pq.poll();
            int d=curr[0];
            int r=curr[1];
            int c=curr[2];
            int movetype=curr[3];
            if(r==n-1&&c==m-1){
                return d;
            }
            if(d>dist[r][c][movetype]){
                continue;
            }
            for(int dir[]:dirc){
                int nr=r+dir[0];
                int nc=c+dir[1];
                if(nr>=0&&nr<n&&nc>=0&&nc<m){
                    int waitime=Math.max(d,moveTime[nr][nc]);
                    int cost=(movetype==0)?1:2;
                    int nextime=cost+waitime;
                    int nextmovetype=1-movetype;
                if(nextime<dist[nr][nc][nextmovetype]){
                    dist[nr][nc][nextmovetype]=nextime;
                    pq.add(new int[]{nextime,nr,nc,nextmovetype});
                }
                }
            }
        }
        return -1;
    }
}