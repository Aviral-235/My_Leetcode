import java.util.*;

class Solution {
    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        if (!online[0]) {
            return -1; 
        }

        int lowerBound = Integer.MAX_VALUE;
        int upperBound = Integer.MIN_VALUE;

        for (int i = 0; i < edges.length; i++) {
            lowerBound = Math.min(lowerBound, edges[i][2]);
            upperBound = Math.max(upperBound, edges[i][2]);
        }

        int ans = -1;
        int low = lowerBound;
        int high = upperBound;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (check(edges, online, k, mid)) {
                ans = mid;
                low = mid + 1; 
            } else {
                high = mid - 1; 
            }
        }
        return ans;
    }

    public boolean check(int[][] grid, boolean[] online, long k, int bound) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int[] edge : grid) {
            int u = edge[0];
            int v = edge[1];
            int cost = edge[2];

            if (cost >= bound) {
                adj.computeIfAbsent(u, h -> new ArrayList<>()).add(new int[]{v, cost});
            }
        }

        int n = online.length;
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;

        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));
        pq.add(new long[]{0, 0});

        while (!pq.isEmpty()) {
            long[] edge = pq.poll();
            int currNode = (int) edge[0];
            long cost = edge[1];

            if (currNode == n - 1) {
                break;
            }

            if (cost > dist[currNode]) {
                continue;
            }

            if (adj.containsKey(currNode)) {
                for (int[] neighbor : adj.get(currNode)) {
                    int nextNode = neighbor[0];
                    int wt = neighbor[1];

                    if (!online[nextNode]) {
                        continue;
                    }

                    if (dist[currNode] + wt < dist[nextNode]) {
                        dist[nextNode] = dist[currNode] + wt;
                        pq.add(new long[]{nextNode, dist[nextNode]});
                    }
                }
            }
        }

        return dist[n - 1] <= k;
    }
}