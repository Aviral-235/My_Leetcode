import java.util.*;
class Solution {
public List<List<Integer>> buildAdjList(int n, int[][] edges) {
    List<List<Integer>> adj = new ArrayList<>();
    for (int i = 0; i < n; i++) {
        adj.add(new ArrayList<>());
    }
    for (int[] edge : edges) {
        int u = edge[0];
        int v = edge[1];
        adj.get(u).add(v);
        adj.get(v).add(u); 
    }
    
    return adj;
}
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        boolean visited[]=new boolean[n];
        Queue<Integer> q=new LinkedList<>();
        List<List<Integer>> list=new ArrayList<>();
        list=buildAdjList(n,edges);
        q.add(source);
        visited[source]=true;
        while(q.isEmpty()==false){
            int u=q.poll();
            if(u==destination){
                return true;
            }
            for(int v:list.get(u)){
                if(visited[v]==false){
                    visited[v]=true;
                    q.add(v);
                }
            }
        }
        return false;
    }
}