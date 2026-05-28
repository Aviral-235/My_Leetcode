class Solution {
    public int frontPartition(int i,int arr[],int k,int dp[]){
        if(i==arr.length){
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        else{

        int max=Integer.MIN_VALUE;
        int sum=0;
        int len=0;
        int maxAns=0;
        for(int j=i;j<Math.min(arr.length,i+k);j++){
            len++;
            max=Math.max(max,arr[j]);
            sum= max*len+frontPartition(j+1,arr,k,dp);
            maxAns=Math.max(sum,maxAns);
        }
        return dp[i]=maxAns;
        }
    }
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int dp[]=new int[arr.length];
        Arrays.fill(dp,-1);
        return frontPartition(0,arr,k,dp);
    }
}