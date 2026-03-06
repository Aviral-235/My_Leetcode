class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int count=0;
        int i=0;
        while(coins>0&&i<costs.length){
            if(coins-costs[i]>=0){
                count++;
                coins-=costs[i];
            }
            
            else{
                break;
            }
            i++;
        }
        return count;
    }
}