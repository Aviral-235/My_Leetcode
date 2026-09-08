class Solution {
    public String removeKdigits(String num, int k) {
      StringBuilder sb=new StringBuilder();
      Stack<Character> st=new Stack<>();
      for(int i=0;i<num.length();i++){
        int numb=num.charAt(i)-'0';
        while(!st.isEmpty()&&(st.peek()-'0')>numb&&k>0){
            st.pop();
            k--;
        }
            st.push(num.charAt(i));
      }  
     
        while(k>0){
           st.pop();
            k--;
        }

        while(st.isEmpty()==false){
            sb.append(st.pop());
        }
        sb.reverse();
        while(sb.length()>0&&sb.charAt(0)=='0'){
            sb.deleteCharAt(0);
        }
        if(sb.length()==0){
            return "0";
        }
        return sb.toString();
    }
}