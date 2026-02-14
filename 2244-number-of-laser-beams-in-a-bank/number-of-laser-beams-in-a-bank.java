class Solution {
    public static int count(String s){
        int count=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1'){
                count++;
            }
        }
        return count;
    }
    public int numberOfBeams(String[] bank) {
        int res=0;
        int i=0;
        int j=1;
        while(j<bank.length){
            if(count(bank[j])==0){
                j++;
            }
                else{
                    res+= count(bank[i])*count(bank[j]);
                    i=j;
                    j++;
                }
        }
        return res;
    }
}