class Solution {
    public int minLengthAfterRemovals(String s) {
        int count_a=0;
        int count_b=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='a'){
                count_a++;
            }
            else{
                count_b++;
            }
        }
        if(count_a==0||count_b==0){
            return s.length();
        }
        int rem= Math.min(count_a,count_b);
        return s.length()- (rem*2);
    }
}