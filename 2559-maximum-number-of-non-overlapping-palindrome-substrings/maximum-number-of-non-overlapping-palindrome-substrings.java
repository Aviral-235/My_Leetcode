class Solution {
    public int maxPalindromes(String s, int k) {
        int res=0;
        for(int i=0;i<=s.length()-k;i++){
            if(isPalindrome(s,i,i+k-1)){
                res++;
                i+=(k-1);
            }
            else if(i<s.length()-k&&isPalindrome(s,i,i+k)){
                res++;
                i+=k;
            }

        }
        return res;
    }
    public boolean isPalindrome(String s,int l,int h){
        while(l<=h){
            if(s.charAt(l)!=s.charAt(h)){
                return false;
            }
            l++;
            h--;
        }
        return true;
    }
}