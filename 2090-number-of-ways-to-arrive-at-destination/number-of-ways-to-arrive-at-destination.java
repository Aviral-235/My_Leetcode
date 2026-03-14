class Solution {
    public int countPaths(int n, int[][] roads) {
        long mod = 1_000_000_007L;
        Map<Integer, List<int[]>> adj = new HashMap<>();
        
        for (int[] road : roads) {
            adj.computeIfAbsent(road[0], k -> new ArrayList<>()).add(new int[]{road[1], road[2]});
            adj.computeIfAbsent(road[1], k -> new ArrayList<>()).add(new int[]{road[0], road[2]});
        }

        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
        pq.add(new long[]{0, 0});

        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;

        long[] ways = new long[n];
        ways[0] = 1;

        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            long d = curr[0];
            int u = (int) curr[1];

            if (d > dist[u]) continue;
            if(adj.containsKey(u)){
            for (int[] edge : adj.get(u)) {
                int v = edge[0];
                long wt = edge[1];

                if (dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                    ways[v] = ways[u];
                    pq.add(new long[]{dist[v], v});
                } else if (dist[u] + wt == dist[v]) {
                    ways[v] = (ways[v] + ways[u]) % mod;
                }
            }
            }
        }
        
        return (int) ways[n - 1];
    }
}