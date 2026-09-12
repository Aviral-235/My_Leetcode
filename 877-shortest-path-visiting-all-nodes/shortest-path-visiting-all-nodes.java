//bitmasking+node ->visited array
//saare nodes se parallely bfs krna hai 
//ek baar bitmask max hogaya mtlb we have reached and then directly return path length

class Solution {
    public int shortestPathLength(int[][] graph) {
        if(graph.length==1){
            return 0;
        }
        int maxBit=(1<<graph.length)-1;
        Queue<int[]> q=new LinkedList<>();
        boolean visited[][]=new boolean[graph.length][(1<<graph.length)];
        for(int i=0;i<graph.length;i++){
            q.add(new int[]{i,1<<i});
            visited[i][1<<i]=true;
        }
        int path=0;
        
        while(!q.isEmpty()){
            int size=q.size();
            path++;
            for(int i=0;i<size;i++){
                int curr[]=q.poll();
                // if(curr[1]==maxBit){
                //     return path;
                // }
                for(int j=0;j<graph[curr[0]].length;j++){
                    int nextmask=(1<<graph[curr[0]][j])|curr[1];
                    if(nextmask==maxBit){
                        return path;
                    }
                    if(!visited[graph[curr[0]][j]][curr[1]|(1<<graph[curr[0]][j])]){
                        visited[graph[curr[0]][j]][curr[1]|(1<<graph[curr[0]][j])]=true;
                        q.add(new int[]{graph[curr[0]][j],curr[1]|(1<<graph[curr[0]][j])});
                    }
                }
            }
        }
        return -1;
    }
}