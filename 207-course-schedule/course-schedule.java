class Solution {
    public static List<List<Integer>> adj_list(int arr[][],int n,int indeg[]){
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<arr.length;i++){
            adj.get(arr[i][1]).add(arr[i][0]);
            indeg[arr[i][0]]++;
        }
        return adj;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int indeg[]=new int[numCourses];
        List<List<Integer>> adj=adj_list(prerequisites,numCourses,indeg);
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indeg[i]==0){
                q.add(i);
            }
        }
        int count=0;
        while(q.isEmpty()==false){
            int u=q.poll();
            count++;
            for(int v:adj.get(u)){
                indeg[v]--;
                if(indeg[v]==0){
                    q.add(v);
                }
            }
        }
        if(count!=numCourses){
            return false;
        }
        return true;
    }
}