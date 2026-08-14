class Solution {
    public int maxDepth(String s) {
        int ctOpen=0;
        int ctClose=0;
        int ct=0;
        int maxCt=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                if(ctClose!=0&&ctClose!=ctOpen){
                    maxCt=Math.max(maxCt,ct);
                    ct-=ctClose;
                    ctOpen-=ctClose;
                    ctClose=0;
                }
                    ctOpen++;
                    ct++;
                
            }
                else if(s.charAt(i)==')'){
                    ctClose++;
                }
                if(ctOpen==ctClose){
                    maxCt=Math.max(maxCt,ctOpen);
                    ctOpen=0;
                    ctClose=0;
                    ct=0;
                }
            
        }
        maxCt=Math.max(maxCt,ct);
        return maxCt;
    }
}