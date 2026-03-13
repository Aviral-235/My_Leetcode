class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer,List<int[]>> adj=new HashMap<>();
        for(int[] time: times){
            adj.computeIfAbsent(time[0],h->new ArrayList<>()).add(new int[]{time[1],time[2]});
        }
            int dist[]=new int[n+1];
            Arrays.fill(dist,Integer.MAX_VALUE);
            dist[k]=0;
            PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
            pq.add(new int[]{0,k});
            while(pq.isEmpty()==false){
                int curr[]=pq.poll();
                int time=curr[0];
                int node=curr[1];
                if(time>dist[node]){
                    continue;
                }
                if(adj.containsKey(node)){
                    for(int[] edge: adj.get(node)){
                        int v=edge[0];
                        int wt=edge[1];
                        if(dist[node]+wt<dist[v]){
                            dist[v]=dist[node]+wt;
                            pq.add(new int[]{dist[v],v});
                        }
                    }
                }
            }
            int maxtime=0;
            for(int i=1;i<=n;i++){
                if(dist[i]==Integer.MAX_VALUE){
                    return -1;
                }
                maxtime=Math.max(dist[i],maxtime);
            }
            return maxtime;
         }
}