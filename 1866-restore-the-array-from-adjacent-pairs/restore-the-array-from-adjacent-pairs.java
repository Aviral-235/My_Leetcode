class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer,List<Integer>> adj=new HashMap<>();
        for(int i=0;i<adjacentPairs.length;i++){
            adj.putIfAbsent(adjacentPairs[i][0],new ArrayList<>());
            adj.putIfAbsent(adjacentPairs[i][1],new ArrayList<>());
            adj.get(adjacentPairs[i][0]).add(adjacentPairs[i][1]);
            adj.get(adjacentPairs[i][1]).add(adjacentPairs[i][0]);
        }
        int src=getSrc(adjacentPairs);
        int arr[]=new int[adjacentPairs.length+1];
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<adjacentPairs.length;i++){
            for(int j=0;j<2;j++){
                set.add(adjacentPairs[i][j]);
            }
        }
        dfs(adj,arr,set,src,0);
        return arr;
    }
    public void dfs(Map<Integer,List<Integer>> adj,int arr[],Set<Integer> set,int src,int idx){
        arr[idx]=src;
        set.remove(src);
        for(int v:adj.get(src)){
            if(set.contains(v)){
                dfs(adj,arr,set,v,idx+1);
            }
        }
    }
    public int getSrc(int arr[][]){
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<2;j++){
                if(set.contains(arr[i][j])){
                set.remove(arr[i][j]);
            }
            else{
                set.add(arr[i][j]);
            }
            }
        }
         int element = set.iterator().next();
         return element;
    }
}