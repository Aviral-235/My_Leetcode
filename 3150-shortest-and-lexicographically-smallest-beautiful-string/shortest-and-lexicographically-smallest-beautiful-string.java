class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        List<Integer> list=new ArrayList<>();
        int j=0;
        int count=0;
        String res="";
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1'){
                count++;
            }
            while(count>k||(count==k&&s.charAt(j)=='0')){
                if(s.charAt(j)=='1'){
                    count--;
                }
                j++;
            }
               if(count==k){
                String temp=s.substring(j,i+1);
                if (res.isEmpty() || temp.length() < res.length() || (temp.length() == res.length() && temp.compareTo(res) < 0)){
                    res=temp;
                }
               } 
        }
        return res;
    }
}