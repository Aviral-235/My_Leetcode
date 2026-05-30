class Solution {
    public int reverse(int n){
        int rev=0;
        while(n>0){
            int rem=n%10;
            rev*=10;
            rev+=rem;
            n/=10;
        }
        return rev;
    }
    public boolean isPrime(int n){
        if(n==1){
            return false;
        }
        for(int i=2;i*i<=n;i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
    public int sumOfPrimesInRange(int n) {
        if(n==1){
            return 0;
        }
        int n_=reverse(n);
        int count=0;
        if(n_>n){
        for(int i=n;i<=n_;i++){
            if(isPrime(i)){
                count+=i;
            }
        }
        }
        else{
            for(int i=n_;i<=n;i++){
                 if(isPrime(i)){
                    count+=i;
            }
        }
        }
        return count;
    }
}