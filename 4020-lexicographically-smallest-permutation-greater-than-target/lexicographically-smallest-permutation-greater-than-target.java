class Solution {
    String res="";
    public String lexGreaterPermutation(String s, String target) {
        int freq[]=new int[26];
        for(char c:s.toCharArray()){
            freq[c-'a']++;
        }

            boolean possible= solve(target.toCharArray(),freq,0,new StringBuilder(),false);
            if(!possible){
                return "";
            }
            return res;
    }
    public boolean solve(char[] target,int freq[],int idx,StringBuilder sb,boolean greater){
        if(idx==target.length){
                if(greater==true){
                    res=sb.toString();
                    return true;
                }
                return false;
            }
            
        for(char c='a';c<='z';c++){
            if(freq[c-'a']==0){
                continue;
            }
            if(!greater&&c<target[idx]){
                continue;
            }
                freq[c-'a']--;
                sb.append(c);
                boolean isgreater=(greater||c>target[idx]);
                if(solve(target,freq,idx+1,sb,isgreater)){
                    return true;
                }
                freq[c-'a']++;
                sb.deleteCharAt(sb.length()-1);
        }
        return false;
    }
}