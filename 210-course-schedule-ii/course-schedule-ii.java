class Solution {
    public static List<List<Integer>> adj_list(int[][]arr,int n,int indeg[]){
        List<List<Integer>> ajc=new ArrayList<>();
        for(int i=0;i<n;i++){
            ajc.add(new ArrayList());
        }
        for(int i=0;i<arr.length;i++){
            ajc.get(arr[i][1]).add(arr[i][0]);
            indeg[arr[i][0]]++;
        }
        return ajc;
    } 
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[]indeg=new int[numCourses];
        List<List<Integer>> ajc=adj_list(prerequisites,numCourses,indeg);
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indeg[i]==0){
                q.add(i);
            }
        }
        int[]ans=new int[numCourses];
        int i=0;
        while(q.isEmpty()==false){
            int u=q.poll();
            ans[i]=u;
            i++;
            for(int v:ajc.get(u)){
                indeg[v]--;
                if(indeg[v]==0){
                    q.add(v);
                }
            }
        }
        if(i!=numCourses){
            return new int[0];
        }
        return ans;
    }
}