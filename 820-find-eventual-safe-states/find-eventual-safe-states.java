class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<graph.length;i++){
            boolean visited[]=new boolean[graph.length];
            boolean backtrack[]=new boolean[graph.length];
            if(!checkCycle(graph,i,visited,backtrack)){
                list.add(i);
            }
        }
        return list;
    }
    public boolean checkCycle(int[][]grid,int src,boolean visited[],boolean backtrack[]){
        visited[src]=true;
        backtrack[src]=true;
        for(int x:grid[src]){
            if(!visited[x]){
                 if(checkCycle(grid,x,visited,backtrack)){
                    return true;
                 }
            }
            else{
                if(backtrack[x]==true){
                    return true;
                }
            }
        }
            backtrack[src]=false;
        return false;
    }
}