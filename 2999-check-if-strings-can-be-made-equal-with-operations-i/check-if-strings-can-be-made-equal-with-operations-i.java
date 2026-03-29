class Solution {
    public boolean canBeEqual(String s1, String s2) {
        int i=0;
        int j=2;
        while(j<4){
            if(s1.charAt(i)==s2.charAt(i)&&s1.charAt(j)==s2.charAt(j)||s1.charAt(i)==s2.charAt(j)&&s1.charAt(j)==s2.charAt(i)){
                j++;
                i++;
            }
            else{
                return false;
            }
            
        }
        return true;
    }
}