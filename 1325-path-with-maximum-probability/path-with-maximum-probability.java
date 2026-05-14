class State {
    int node;
    double prob;
    State(int node, double prob) {
        this.node = node;
        this.prob = prob;
    }
}

class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        Map<Integer, List<double[]>> adj = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            double prob = succProb[i];
            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(new double[]{(double) v, prob});
            adj.computeIfAbsent(v, k -> new ArrayList<>()).add(new double[]{(double) u, prob});
        }

        double[] dist = new double[n];
        Arrays.fill(dist, 0.0);
        dist[start_node] = 1.0;

        PriorityQueue<State> pq = new PriorityQueue<>((a, b) -> Double.compare(b.prob, a.prob));
        pq.add(new State(start_node, 1.0));

        while (!pq.isEmpty()) {
            State curr = pq.poll();
            int node = curr.node;
            double currprob = curr.prob;

            if (node == end_node) {
                return currprob;
            }

            if (currprob < dist[node]) {
                continue;
            }

            if (!adj.containsKey(node)) continue;

            for (double[] edge : adj.get(node)) {
                int nextnode = (int) edge[0];
                double edgeProb = edge[1];
                if (currprob * edgeProb > dist[nextnode]) {
                    dist[nextnode] = currprob * edgeProb;
                    pq.add(new State(nextnode, dist[nextnode]));
                }
            }
        }

        return 0.0;
    }
}