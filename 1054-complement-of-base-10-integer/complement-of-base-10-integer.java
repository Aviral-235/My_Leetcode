class Solution {
    public int bitwiseComplement(int n) {
      String binary = Integer.toBinaryString(n);
      String ans="";
      for(int i=0;i<binary.length();i++){
        if(binary.charAt(i)=='1'){
            ans+="0";
        }
        else{
            ans+="1";
        }
      }
      int decimal = Integer.parseInt(ans, 2);
      return decimal;
    }
}