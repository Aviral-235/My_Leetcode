class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            List<Integer> res = new ArrayList<>();
            res.add(0);
            return res;
        }

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        
        int[] degree = new int[n];
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
            degree[edge[0]]++;
            degree[edge[1]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) {
                q.add(i);
            }
        }

        int remainingNodes = n;
        while (remainingNodes > 2) {
            int layerSize = q.size();
            remainingNodes -= layerSize;
            for (int i = 0; i < layerSize; i++) {
                int leaf = q.poll();
                for (int neighbor : adj.get(leaf)) {
                    degree[neighbor]--;
                    if (degree[neighbor] == 1) {
                        q.add(neighbor);
                    }
                }
            }
        }

        return new ArrayList<>(q);
    }
}