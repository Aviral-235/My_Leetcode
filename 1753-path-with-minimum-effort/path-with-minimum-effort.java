class Solution {
    public int minimumEffortPath(int[][] heights) {
        int row=heights.length;
        int col=heights[0].length;
        int graph[][]=new int[row][col];
        for(int[]rows:graph){
            Arrays.fill(rows,Integer.MAX_VALUE);
        }
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.add(new int[]{0,0,0});
        graph[0][0]=0;
        int dirc[][]={{0,1},{0,-1},{1,0},{-1,0}};
        while(pq.isEmpty()==false){
            int curr[]=pq.poll();
            int d=curr[0];
            int r=curr[1];
            int c=curr[2];
            if(r==row-1&&c==col-1){
                return d;
            }
            if(d>graph[r][c]){
                continue;
            }
            for(int[] dir: dirc){
                int nr=r+dir[0];
                int nc=c+dir[1];
                int neweffort=0;
                if(nr>=0&&nr<row && nc>=0&&nc<col){
                    neweffort=Math.max(d,Math.abs(heights[r][c]-heights[nr][nc]));
                    if(neweffort<graph[nr][nc]){
                    graph[nr][nc]=neweffort;
                    pq.add(new int[]{neweffort,nr,nc});
                }
                }
                
            }
        }
        return 0;
    }
}