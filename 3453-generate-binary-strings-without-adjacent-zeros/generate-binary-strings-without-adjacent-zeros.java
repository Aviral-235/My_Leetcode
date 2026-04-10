class Solution {
    public List<String> no_2_zero(int n,List<String> str,String s){
        if(n==0){
            str.add(s);
            return str;
        }
        if(s.length()==0){
          no_2_zero(n-1,str,s+'0');
          no_2_zero(n-1,str,s+'1');
        }
        else if(s.charAt(s.length()-1)=='0'){
            no_2_zero(n-1,str,s+'1');
        }
        else{
            no_2_zero(n-1,str,s+'0');
            no_2_zero(n-1,str,s+'1');
        }
        return str;
    }
    public List<String> validStrings(int n) {
        String s="";
        List<String> str=new ArrayList<>();
        return no_2_zero(n,str,s);
    }
}