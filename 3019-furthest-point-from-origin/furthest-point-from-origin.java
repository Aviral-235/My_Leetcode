class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int count_l=0;
        int count_r=0;
        int count_=0;
        for(int i=0;i<moves.length();i++){
            if(moves.charAt(i)=='L'){
                count_l++;
            }
            else if(moves.charAt(i)=='R'){
                count_r++;
            }
            else{
                count_++;
            }
        }
        if(count_r>=count_l){
            count_r+=count_;
            return count_r-count_l;
        }
        count_l+=count_;
        return count_l-count_r;
    }
}