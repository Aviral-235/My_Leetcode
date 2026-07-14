class Solution {
    int mod=1_000_000_000+7;
    public int subsequencePairCount(int[] nums) {
        int dp[][][]=new int[nums.length][201][201];
        for(int twod[][]:dp){
            for(int row[]:twod){
                Arrays.fill(row,-1);
            }
        }
        return find_pairs(0,nums,0,0,dp);
    }
    public int find_pairs(int i,int nums[],int gcd_1,int gcd_2,int dp[][][]){
        if(i==nums.length){
            if(gcd_1==gcd_2&&gcd_1!=0&&gcd_2!=0){
                return 1;
            }
                return 0;
            }
            if(dp[i][gcd_1][gcd_2]!=-1){
                return dp[i][gcd_1][gcd_2];
            }
           
        long total= (long)find_pairs(i+1,nums,getGcd(gcd_1,nums[i]),gcd_2,dp)+
        find_pairs(i+1,nums,gcd_1,getGcd(gcd_2,nums[i]),dp)+
        find_pairs(i+1,nums,gcd_1,gcd_2,dp);
            return dp[i][gcd_1][gcd_2]=(int)(total%mod);
        }
        
    
    public int getGcd(int a,int b){
        while (b != 0) {
        int temp = b;
        b = a % b;
        a = temp;
    }
        return Math.abs(a);
    }
}