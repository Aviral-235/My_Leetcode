class Solution {
    public int[] executeInstructions(int n, int[] startPos, String s) {
       int row=startPos[0];
       int col=startPos[1];
       int ans[]=new int[s.length()];
       for(int i=0;i<ans.length;i++){
        int count=0;
        for(int j=i;j<ans.length;j++){
            if(s.charAt(j)=='R'){
                if(col+1>n-1){
                    break;
                }
                else{
                    count++;
                    col++;
                }
            }
            else if(s.charAt(j)=='L'){
                if(col-1<0){
                    break;
                }
                else{
                    count++;
                    col--;
                }
            }
            else if(s.charAt(j)=='U'){
                if(row-1<0){
                    break;
                }
                else{
                    count++;
                    row--;
                }
            }
            else if(s.charAt(j)=='D'){
                if(row+1>n-1){
                    break;
                }
                else{
                    count++;
                    row++;
                }
            }
           
        }
         ans[i]=count;
         row=startPos[0];
         col=startPos[1];
       } 
       return ans;
    }
}