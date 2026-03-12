class Solution {
    public int bestClosingTime(String customers) {
      int prefix[]=new int[customers.length()+1];
      int suffix[]=new int[customers.length()+1];
      prefix[0]=0;
      suffix[suffix.length-1]=0;
      int count=0;
      for(int i=1;i<prefix.length;i++){
        if(customers.charAt(i-1)=='N'){
            count++;
        }
        prefix[i]=count;
      }
      count=0;
      for(int i=suffix.length-2;i>=0;i--){
        if(customers.charAt(i)=='Y'){
            count++;
        }
            suffix[i]=count;
        
      } 
      int penalty=Integer.MAX_VALUE;
      for(int i=0;i<suffix.length;i++){
            penalty=Math.min(suffix[i]+prefix[i],penalty);
      } 
      for(int i=0;i<suffix.length;i++){
        if(penalty==suffix[i]+prefix[i]){
            return i;
         }
      }
      return 0;
    }
}