class Solution {
    public boolean checkBipartite(List<List<Integer>> adj,int color[],int i){
        Queue<Integer> q=new LinkedList<>();
        q.add(i);
        color[i]=0;
        while(q.isEmpty()==false){
            int v=q.poll();
            int colorTemp=color[v];
            for(int u:adj.get(v)){
                if(color[u]==-1){
                    if(colorTemp==0){
                        color[u]=1;
                    }
                    else{
                        color[u]=0;
                    }
                    q.add(u);
                }
                else{
                    if(color[u]==color[v]){
                        return false;
                    }
                }
                
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int u = 0; u < n; u++) {
            for (int v : graph[u]) {
                adj.get(u).add(v);
            }
        }
        int color[]=new int[n];
        Arrays.fill(color,-1);
        for(int i=0;i<n;i++){
            if(color[i]==-1){
            if(!checkBipartite(adj, color,i)){
                return false;
            }
            }
        }
        return true;
    }
}