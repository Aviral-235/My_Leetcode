class Solution {
    public boolean checkOnesSegment(String s) {
        int count=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1'){
                count++;
                if(i+1<s.length()){
                        while(i+1<s.length()&&s.charAt(i+1)=='1'){
                        i++;
                    }
                }
            }
        }
        if(count>1){
            return false;
        }
        return true;
    }
}