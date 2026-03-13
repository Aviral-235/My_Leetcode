class Solution {
    public static int[][] graph(int[][] points){
        int[][] graph=new int[points.length][points.length];
        for(int i=0;i<graph.length;i++){
            for(int j=0;j<graph.length;j++){
                graph[i][j]= Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1]);
            }
        }
        return graph;
    }
    public int minCostConnectPoints(int[][] points) {
        int v=points.length;
        int dist[]=new int[v];
        Arrays.fill(dist,Integer.MAX_VALUE);
        boolean visited[]=new boolean[v];
        int[][] graph= graph(points);
        dist[0]=0;
        int res=0;
        for(int count=0;count<v;count++){
            int u=-1;
        for(int i=0;i<v;i++){
            
            if(!visited[i]&&(u==-1||dist[u]>dist[i])){
                u=i;
            }
        }
        visited[u]=true;
        res+=dist[u];
        for(int k=0;k<v;k++){
            if(!visited[k]&&graph[u][k]!=0&&graph[u][k]<dist[k]){
                    dist[k]=graph[u][k];
                }
            }
        }
        return res;
    }
}