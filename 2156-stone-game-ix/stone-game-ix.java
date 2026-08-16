class Solution {
    public boolean stoneGameIX(int[] stones) {
        for(int i=0;i<stones.length;i++){
            stones[i]=stones[i]%3;
        }
        int ctZero=0;
        int ctOne=0;
        int ctTwo=0;
        for(int x:stones){
            if(x==0){
                ctZero++;
            }
            else if(x==1){
                ctOne++;
            }
            else{
                ctTwo++;
            }
        }
        if(ctZero%2==0&&ctOne>0&&ctTwo>0){
            return true;
        }
        else if(ctZero%2!=0&&Math.abs(ctOne-ctTwo)>2){
            return true;
        }
        return false;
    }
}