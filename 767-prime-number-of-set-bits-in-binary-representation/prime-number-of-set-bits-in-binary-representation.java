class Solution {
    public static boolean is_prime(int n){
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
    public static int count_bits(int n){
        int count=0;
        while(n>0){
            count++;
            n&=(n-1);
        }
        return count;
    }
    public int countPrimeSetBits(int left, int right) {
        int count=0;
        for(int i=left;i<=right;i++){
            int temp=count_bits(i);
            if(is_prime(temp)==true){
                count++;
            }
        }
            return count;
    }

}