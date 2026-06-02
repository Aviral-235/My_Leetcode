class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> path=new ArrayList<>();
        return paths(graph,graph.length-1,0,path,ans);
    }
    public List<List<Integer>> paths(int grid[][],int n,int currentNode,List<Integer> currPath,List<List<Integer>> ans){
        currPath.add(currentNode);
        if(currentNode==n){
            ans.add(new ArrayList<>(currPath));
        }
        else{
            for(int u:grid[currentNode]){
                paths(grid,n,u,currPath,ans);
            }
        }
        currPath.remove(currPath.size()-1);
        return ans;
    }
}