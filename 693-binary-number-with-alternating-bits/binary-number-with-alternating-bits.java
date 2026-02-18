class Solution {
    public boolean hasAlternatingBits(int n) {
        int flag=0;
        while(n>0){
            if((n&1)==(n>>1&1)){
                return false;
            }
            n=n>>1;
        }
        return true;
    }
}