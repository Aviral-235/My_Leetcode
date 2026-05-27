class Solution {
    public int minCuts(int i,int j,int arr[],int dp[][]){
        if(i>j){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        else{
        int min=Integer.MAX_VALUE;
        for(int idx=i;idx<=j;idx++){
            int cost=arr[j+1]-arr[i-1]+minCuts(i,idx-1,arr,dp)+minCuts(idx+1,j,arr,dp);
            min=Math.min(min,cost);
        }
        return dp[i][j]=min;
        }
    }
    public int minCost(int n, int[] cuts) {
        int dp[][]=new int[cuts.length+1][cuts.length+1];
        for(int rows[]:dp){
            Arrays.fill(rows,-1);
        }
        Arrays.sort(cuts);
        int arr[]=new int[cuts.length+2];
        arr[0]=0;
        arr[arr.length-1]=n;
        for(int i=1;i<arr.length-1;i++){
            arr[i]=cuts[i-1];
        }
        return minCuts(1,cuts.length,arr,dp);
    }
}