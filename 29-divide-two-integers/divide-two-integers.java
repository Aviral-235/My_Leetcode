class Solution {
    public int divide(int dividend, int divisor) {
        boolean sign=true;
        if(dividend>0&&divisor<0||dividend<0&&divisor>0){
            sign=false;
        }
        if(dividend==divisor){
            return 1;
        }
        long divi=Math.abs((long)dividend);
        long div=Math.abs((long)divisor);
        long ans=0;
        
        while(divi>=div){
            int cnt=0;
            while(divi>=(div<<(cnt+1))){
                cnt++;
            }
            ans+=1L<<cnt;
            divi-=div<<cnt;
        }
        if(ans>Integer.MAX_VALUE&&sign==true){
            return Integer.MAX_VALUE;
        }
        if(-ans<Integer.MIN_VALUE&&sign==false){
            return Integer.MIN_VALUE;
        }
        if(sign==false){
            return (int)-ans;
        }
        return (int)ans;
    }
}