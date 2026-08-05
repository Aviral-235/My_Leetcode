class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : invocations) {
            adj.get(edge[0]).add(edge[1]);
        }

        // Phase 1: Reachability check via BFS starting from k
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        
        visited[k] = true;
        q.add(k);

        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : adj.get(u)) {
                if (!visited[v]) {
                    visited[v] = true;
                    q.add(v);
                }
            }
        }

        // Phase 2: Check if any non-suspicious method calls a suspicious method
        for (int[] edge : invocations) {
            int u = edge[0];
            int v = edge[1];
            if (!visited[u] && visited[v]) {
                List<Integer> list = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    list.add(i);
                }
                return list;
            }
        }

        // Phase 3: Collect and return only the non-suspicious methods
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                result.add(i);
            }
        }

        return result;
    }
}