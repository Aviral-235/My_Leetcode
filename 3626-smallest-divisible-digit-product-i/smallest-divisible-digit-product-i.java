class Solution {
    public int smallestNumber(int n, int t) {
        while(prod(n)%t!=0){
            n++;
        }
        return n;
    }
    public int prod(int n){
        int prod=1;
        while(n>0){
            prod*=n%10;
            n/=10;
        }
        return prod;
    }
}