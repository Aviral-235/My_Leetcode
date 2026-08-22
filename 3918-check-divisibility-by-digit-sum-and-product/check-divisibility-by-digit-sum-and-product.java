class Solution {
    public boolean checkDivisibility(int n) {
        int sum=Sum(n);
        int prod=Product(n);
        if(n%(sum+prod)==0){
            return true;
        }
        return false;
    }
    public int Sum(int n){
        int sum=0;
        while(n>0){
            sum+=n%10;
            n/=10;
        }
        return sum;
    }
    public int Product(int n){
        int prod=1;
        while(n>0){
            prod*=n%10;
            n/=10;
        }
        return prod;
    }
}