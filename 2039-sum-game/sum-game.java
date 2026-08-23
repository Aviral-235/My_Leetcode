class Solution {
    public boolean sumGame(String num) {
        int ctFirstHalf=0;
        int ctSecondHalf=0;
        int sumFirstHalf=0;
        int sumSecondHalf=0;
        for(int i=0;i<num.length();i++){
            char c=num.charAt(i);
            if(c=='?'&&(2*i<num.length())){
                ctFirstHalf++;
            }
            else if(c=='?'&&(2*i>=num.length())){
                ctSecondHalf++;
            }
            else if(2*i<num.length()){
                int x=num.charAt(i)-'0';
                sumFirstHalf+=x;
            }
            else{
                int x=num.charAt(i)-'0';
                sumSecondHalf+=x;
            }
        }
        if((ctFirstHalf+ctSecondHalf)%2==1){
            return true;
        }
        if(sumFirstHalf-sumSecondHalf==((ctSecondHalf-ctFirstHalf)/2)*9){
            return false;
        }
        return true;

    }
}