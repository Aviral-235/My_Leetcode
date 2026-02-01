class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int curr_pet=0;
        int prev_pet=0;
        int start=0;
        for(int i=0;i<gas.length;i++){
            curr_pet+= gas[i]-cost[i];
            if(curr_pet<0){
                start=i+1;
                prev_pet+=curr_pet;
                curr_pet=0;
            }
        }
        if(curr_pet+prev_pet>=0){
            return start;
        }
        return -1;
    }
}