class Solution {
    public String addBinary(String a, String b) {
        int idx_a=a.length()-1;
        int idx_b=b.length()-1;
        int carry=0;
        StringBuilder s=new StringBuilder();
        while(idx_a>=0&&idx_b>=0){
            if (a.charAt(idx_a) == '0' && b.charAt(idx_b) == '0' && carry == 0) {
                carry = 0;
                s.append('0');
            } else if (a.charAt(idx_a) == '0' && b.charAt(idx_b) == '0' && carry == 1) {
                carry = 0;
                s.append('1');
            } else if (a.charAt(idx_a) == '0' && b.charAt(idx_b) == '1' && carry == 0) {
                carry = 0;
                s.append('1');
            } else if (a.charAt(idx_a) == '0' && b.charAt(idx_b) == '1' && carry == 1) {
                carry = 1;
                s.append('0');
            } else if (a.charAt(idx_a) == '1' && b.charAt(idx_b) == '0' && carry == 0) {
                carry = 0;
                s.append('1');
            } else if (a.charAt(idx_a) == '1' && b.charAt(idx_b) == '0' && carry == 1) {
                carry = 1;
                s.append('0');
            } else if (a.charAt(idx_a) == '1' && b.charAt(idx_b) == '1' && carry == 0) {
                carry = 1;
                s.append('0');
            } else if (a.charAt(idx_a) == '1' && b.charAt(idx_b) == '1' && carry == 1) {
                carry = 1;
                s.append('1');
            }
                idx_a--;
                idx_b--;
                    }
            while(idx_a>=0){
                if(a.charAt(idx_a)=='0'&&carry==0){
                    carry=0;
                    s.append('0');
                }
                else if(a.charAt(idx_a)=='0'&&carry==1){
                    carry=0;
                    s.append('1');
                }
                else if(a.charAt(idx_a)=='1'&&carry==1){
                    carry=1;
                    s.append('0');
                }
                else if(a.charAt(idx_a)=='1'&&carry==0){
                    carry=0;
                    s.append('1');
                }
                idx_a--;
            }
            while(idx_b>=0){
                if(b.charAt(idx_b)=='0'&&carry==0){
                    carry=0;
                    s.append('0');
                }
                else if(b.charAt(idx_b)=='0'&&carry==1){
                    carry=0;
                    s.append('1');
                }
                else if(b.charAt(idx_b)=='1'&&carry==1){
                    carry=1;
                    s.append('0');
                }
                else if(b.charAt(idx_b)=='1'&&carry==0){
                    carry=0;
                    s.append('1');
                }
                idx_b--;
            }
            if(carry==1){
                s.append('1');
            }
            s.reverse();
            return s.toString();
        }
}