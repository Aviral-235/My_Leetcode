class Solution {
    public boolean dfs(int arr[],int idx,boolean []visited){
        if (idx < 0 || idx >= arr.length || visited[idx]) {
            return false;
        }
        if(arr[idx]==0){
            return true;
        }
        visited[idx]=true;
        int next=idx+arr[idx];
        int prev=idx-arr[idx];
        boolean path_1=false;
        if(next<arr.length&&visited[next]==false){
            path_1= dfs(arr,next,visited);
        }
        boolean path_2=false;
        if(prev>=0&&visited[prev]==false){
            path_2= dfs(arr,prev,visited);
        }
        boolean res=path_1||path_2;
        return res;
    }
    public boolean canReach(int[] arr, int start) {
        boolean visited[]=new boolean[arr.length];
        return dfs(arr,start,visited);
    }
}