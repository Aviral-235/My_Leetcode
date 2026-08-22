class Solution {
    public int characterReplacement(String s, int k) {
        int freq[]=new int[26];   
        int maxLen=0;
        for(char c='A';c<='Z';c++){
            int j=0;
            int temp=k;
        for(int i=0;i<s.length();i++){
           if(s.charAt(i)!=c){
            temp--;
           }
           while(temp<0){
            if(s.charAt(j)!=c){
                temp++;
            }
            j++;
           }
            maxLen=Math.max(maxLen,i-j+1);
        }
    }
        return maxLen;
    }
}