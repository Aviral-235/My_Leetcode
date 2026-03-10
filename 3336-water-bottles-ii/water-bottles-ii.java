class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int count=0;
        int res=numBottles;
        while(numBottles>=numExchange){
            count++;
            numBottles-=numExchange;
            numBottles+=1;
            numExchange+=1;
        }
        return res+count;
    }
}