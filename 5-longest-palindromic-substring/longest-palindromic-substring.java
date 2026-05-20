class Solution {
    public String rev(String s){
        String rev="";
        for(int i=s.length()-1;i>=0;i--){
            rev+=s.charAt(i);
        }
        return rev;
    }
    public String longestPalindrome(String s) {
        String s2=rev(s);
        int dp[][]=new int[s.length()+1][s2.length()+1];
        for(int i=0;i<=s.length();i++){
            dp[i][0]=0;
        }
        for(int j=0;j<s2.length()+1;j++){
            dp[0][j]=0;
        }
        for(int i=1;i<s.length()+1;i++){
            for(int j=1;j<s2.length()+1;j++){
                 if(s.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }   
                else{
                     dp[i][j]=0;
                }
            }
        }
        String ans="";
        int r=0;
        int c=0;
        int max=0;
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(dp[i][j]>max&& (i - dp[i][j] == s.length() - j)){
                    max=dp[i][j];
                    r=i;
                    c=j;
                }
            }
        }
        while(max>0){
                ans+=s.charAt(r-1);
            r--;
            c--;
            max--;
        }
        return ans;
    }
}