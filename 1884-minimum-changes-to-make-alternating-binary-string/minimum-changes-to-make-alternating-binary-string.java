class Solution {
    public int minOperations(String s) {
        int count_0=0;
        int count_1=0;
        for(int i=0;i<s.length();i++){
            if(i%2==0){
                if(s.charAt(i)!='0'){
                    count_0++;
                }
            }
                else{
                    if(s.charAt(i)!='1'){
                        count_0++;
                    }
                }
                if(i%2==0){
                    if(s.charAt(i)!='1'){
                        count_1++;
                    }
                }
                else{
                    if(s.charAt(i)!='0'){
                        count_1++;
                    }
                }
            
        }
        return Math.min(count_0,count_1);
    }
}