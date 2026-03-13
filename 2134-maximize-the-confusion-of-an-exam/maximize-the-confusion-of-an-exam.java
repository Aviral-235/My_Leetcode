class Solution {
    public static int maxlen(String s,int k,char target){
        int left=0;
        int changes=0;
        int maxlen=0;
        for(int right=0;right<s.length();right++){
            if(s.charAt(right)!=target){
                changes++;
            }
            if(changes>k){
                while(changes>k){
                    if(s.charAt(left)!=target){
                        changes--;
                    }
                    left++;
                }
            }
            maxlen=Math.max(maxlen,right-left+1);
        }
        return maxlen;
    }
    public int maxConsecutiveAnswers(String answerKey, int k) {
        return Math.max(maxlen(answerKey,k,'T'),maxlen(answerKey,k,'F'));
    }
}