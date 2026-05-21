class Solution {
    public int minDistance(String word1, String word2) {
        int prev[]=new int[word2.length()+1];
        
        for(int i=0;i<=word2.length();i++){
            prev[i]=i;
        }
        for(int i=1;i<word1.length()+1;i++){
            int curr[]=new int[word2.length()+1];
            curr[0]=i;
            for(int j=1;j<word2.length()+1;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    curr[j]=prev[j-1];
                }
                else{
                    curr[j] = 1 + Math.min(curr[j-1], Math.min(prev[j], prev[j-1]));
                }
            }
            prev=curr;
        }
        return prev[word2.length()];
    }
}