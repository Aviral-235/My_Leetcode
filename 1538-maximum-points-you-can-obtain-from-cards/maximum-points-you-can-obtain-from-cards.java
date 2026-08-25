class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int lsum=0;
        int rsum=0;
        int res=0;
        for(int i=0;i<k;i++){
            lsum+=cardPoints[i];
        }
        int idx=k-1;
        for(int i=cardPoints.length-1;i>=cardPoints.length-k;i--){
            res=Math.max(res,lsum+rsum);
            lsum-=cardPoints[idx];
            rsum+=cardPoints[i];
            idx--;
        }
        res=Math.max(res,lsum+rsum);
        return res;
    }
}