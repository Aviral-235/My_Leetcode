class Solution {
    public int countCommas(int n) {
        int count=Count(n);
        if(count<=3){
            return 0;
        }
        if(count==4){
            return n-1000+1;
        }
            return 9000+(n-10000+1);

    }
    public int Count(int n){
        int count=0;
        while(n>0){
            count++;
            n/=10;
        }
        return count;
    }
}
