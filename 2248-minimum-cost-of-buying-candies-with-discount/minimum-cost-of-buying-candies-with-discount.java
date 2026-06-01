class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        long cost_=0;
        int count=0;
        for(int i=cost.length-1;i>=0;i--){
            if(count==2){
                count=0;
                continue;
            }
            cost_+=cost[i];
            count++;

        }
        return (int)cost_;
    }
}