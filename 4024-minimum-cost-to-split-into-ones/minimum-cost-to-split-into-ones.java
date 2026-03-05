class Solution {
    public int minCost(int n) {
        int cost=0;
        int a=Integer.MAX_VALUE;
        int b=Integer.MAX_VALUE;
        if(n==1){
            return 0;
        }
        while(a!=1){
            a=n-1;
            b=1;
            cost+=a*b;
            n=a;
        }
        return cost;
    }
}