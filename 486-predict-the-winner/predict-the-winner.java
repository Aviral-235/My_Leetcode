class Solution {
    public boolean predictTheWinner(int[] nums) {
        int sum=0;
        for(int x:nums){
            sum+=x;
        }
        int dp[][][]=new int[nums.length][nums.length][2];
        for(int edge[][]:dp){
            for(int row[]:edge){
                Arrays.fill(row,-1);
            }
        }
        int score=recursion(nums,0,nums.length-1,0,dp);
        if(score*2>=sum){
            return true;
        }
        return false;
    }
    public int recursion(int arr[],int i,int j,int chanceOf,int dp[][][]){
        if(i>arr.length-1||j<0){
            return 0;
        }
        if(dp[i][j][chanceOf]!=-1){
            return dp[i][j][chanceOf];
        }
        if(i==j){
            if(chanceOf==0){
                return dp[i][j][chanceOf]=arr[i];
            }
            return dp[i][j][chanceOf]=0;
        }
        if(chanceOf==0){
            return dp[i][j][chanceOf]=Math.max(arr[i]+recursion(arr,i+1,j,1,dp),arr[j]+recursion(arr,i,j-1,1,dp));
        }
           return dp[i][j][chanceOf]=Math.min(recursion(arr,i+1,j,0,dp),recursion(arr,i,j-1,0,dp));
        }
    }
