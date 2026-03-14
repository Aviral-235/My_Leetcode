class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int dist[]=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;
        Map<Integer,List<int[]>> adj=new HashMap<>();
        for(int[] time: flights){
            adj.computeIfAbsent(time[0],h->new ArrayList<>()).add(new int[]{time[1],time[2]});
        }
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.add(new int[]{0,src,0});
        while(pq.isEmpty()==false){
            int curr[]=pq.poll();
            int stops=curr[0];
            int curr_node=curr[1];
            int price=curr[2];
            if(stops>k){
                continue;
            }
            if(adj.containsKey(curr_node)){
                for(int[]edge: adj.get(curr_node)){
                    int node=edge[0];
                    int wt=edge[1];
                    if(price+wt<dist[node]&&stops<=k){
                        dist[node]=price+wt;
                        pq.add(new int[]{stops+1,node,dist[node]});
                    }
                }
            }
        }
        if(dist[dst]==Integer.MAX_VALUE){
            return -1;
        }
        return dist[dst];
    }
}