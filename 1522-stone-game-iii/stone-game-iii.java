class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int dp[][]=new int[stoneValue.length][2];
        for(int rows[]:dp){
            Arrays.fill(rows,-1);
        }
        int alice=dp_recursion(stoneValue,0,0,dp);
        int sum=0;
        for(int x:stoneValue){
            sum+=x;
        }
        int bob=sum-alice;
        if(alice>bob){
            return "Alice";
        }
        else if(alice==bob){
            return "Tie";
        }
        return "Bob";
    }
    public int dp_recursion(int[] arr,int idx,int chance,int dp[][]){
        if(idx>=arr.length){
            return 0;
        }
        if(dp[idx][chance]!=-1){
            return dp[idx][chance];
        }
        else{
        if(chance==0){
            int pick1=arr[idx]+dp_recursion(arr,idx+1,1,dp);
            int pick2=Integer.MIN_VALUE;
            if(idx<arr.length-1){
                pick2=arr[idx]+arr[idx+1]+dp_recursion(arr,idx+2,1,dp);
            }
            int pick3=Integer.MIN_VALUE;
            if(idx<arr.length-2){
                pick3=arr[idx]+arr[idx+1]+arr[idx+2]+dp_recursion(arr,idx+3,1,dp);
            }
            return dp[idx][chance]= Math.max(pick1,Math.max(pick2,pick3));
        }
        int pick1=dp_recursion(arr,idx+1,0,dp);
            int pick2=Integer.MAX_VALUE;
            if(idx<arr.length-1){
                pick2=dp_recursion(arr,idx+2,0,dp);
            }
            int pick3=Integer.MAX_VALUE;
            if(idx<arr.length-2){
                pick3=dp_recursion(arr,idx+3,0,dp);
            }
            return dp[idx][chance]=Math.min(pick1,Math.min(pick2,pick3));
    }
    }
}