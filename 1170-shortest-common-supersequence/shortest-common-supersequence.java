class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int dp[][]=new int[str1.length()+1][str2.length()+1];
        for(int i=0;i<=str1.length();i++){
            dp[i][0]=0;
        }
        for(int j=0;j<str2.length()+1;j++){
            dp[0][j]=0;
        }
        for(int i=1;i<str1.length()+1;i++){
            for(int j=1;j<str2.length()+1;j++){
                 if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }   
                else{
                     dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        String ans="";
        int i=str1.length();
        int j=str2.length();
        while(i>0&&j>0){
            if(str1.charAt(i-1)==str2.charAt(j-1)){
                ans+=str1.charAt(i-1);
                i--;
                j--;
            }
            else if(dp[i-1][j]>dp[i][j-1]){
                ans+=str1.charAt(i-1);
                i--;
            }
            else{
                ans+=str2.charAt(j-1);
                j--;
            }

        }
        if(i>0){
            while(i>0){
                ans+=str1.charAt(i-1);
                i--;
            }
        }
        if(j>0){
            while(j>0){
                ans+=str2.charAt(j-1);
                j--;
            }
        }
        return rev(ans);
    }
    public String rev(String s){
        String rev="";
        for(int i=s.length()-1;i>=0;i--){
            rev+=s.charAt(i);
        }
        return rev;
    }
}