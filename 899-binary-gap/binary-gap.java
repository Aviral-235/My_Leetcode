class Solution {
    public int binaryGap(int n) {
        int lastpos=-1;
        int res=0;
        for(int i=0;i<32;i++){
            if(((n>>i)&1)==1){
                if(lastpos!=-1){
                    res=Math.max(res, i-lastpos);
                }
                lastpos=i;
            }
        }
        // if(res<count){
        //     res=count+1;
        // }
        return res;
    }
}