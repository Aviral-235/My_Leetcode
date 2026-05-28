class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int dp[]=new int[arr.length+1];
        Arrays.fill(dp,0);
        for(int i=arr.length-1;i>=0;i--){
            int max=Integer.MIN_VALUE;
        int sum=0;
        int len=0;
        int maxAns=0;
        for(int j=i;j<Math.min(arr.length,i+k);j++){
            len++;
            max=Math.max(max,arr[j]);
            sum= max*len+dp[j+1];
            maxAns=Math.max(sum,maxAns);
        }
            dp[i]=maxAns;
        }
        return dp[0];
    }
}