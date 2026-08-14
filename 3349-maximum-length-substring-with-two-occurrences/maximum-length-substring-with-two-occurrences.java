class Solution {
    public int maximumLengthSubstring(String s) {
        int freq[]=new int[26];
        
        int maxlen=0;
        int j=0;
        for(int i=0;i<s.length();i++){
            if(freq[s.charAt(i)-'a']==2){
                maxlen=Math.max(maxlen,i-j);
                while(freq[s.charAt(i)-'a']==2){
                    freq[s.charAt(j)-'a']--;
                    j++;
                }
            }
            freq[s.charAt(i)-'a']++;
        }
        maxlen=Math.max(maxlen,s.length()-j);
        return maxlen;
    }
}