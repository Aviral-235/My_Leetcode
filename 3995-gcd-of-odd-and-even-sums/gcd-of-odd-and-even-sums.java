class Solution {
    public static int gcd(int a,int b){
        while( b!=0){
            int rem=a%b;
            a=b;
            b=rem;
        }
        return a;
    }
    public int gcdOfOddEvenSums(int n) {
        int even_sum= ((n*(n+1)));
        int odd_sum=n*n;
        return gcd(even_sum,odd_sum);
    }
}