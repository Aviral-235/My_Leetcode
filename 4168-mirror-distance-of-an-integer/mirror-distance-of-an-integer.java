class Solution {
    public static int reverse(int n){
        int rev=0;
        while(n>0){
            int rem=n%10;
            rev*=10;
            rev+=rem;
            n/=10;
        }
        return rev;
    }
    public int mirrorDistance(int n) {
        return Math.abs(n-reverse(n));
    }
}