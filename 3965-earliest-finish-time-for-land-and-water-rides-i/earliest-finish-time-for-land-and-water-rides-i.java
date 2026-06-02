class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
      int ans=Integer.MAX_VALUE;
      for(int i=0;i<landDuration.length;i++){
        for(int j=0;j<waterDuration.length;j++){
            int s_t=landStartTime[i];
            int e_t=s_t+landDuration[i];
            if(waterStartTime[j]>e_t){
                ans=Math.min(ans,waterStartTime[j]+waterDuration[j]);
            }
            else{
                ans=Math.min(ans,e_t+waterDuration[j]);
            }
        }
      }
      for(int i=0;i<waterDuration.length;i++){
        for(int j=0;j<landDuration.length;j++){
            int s_t=waterStartTime[i];
            int e_t=s_t+waterDuration[i];
            if(landStartTime[j]>e_t){
                ans=Math.min(ans,landStartTime[j]+landDuration[j]);
            }
            else{
                ans=Math.min(ans,e_t+landDuration[j]);
            }
        }
      }    
      return ans;
    }
}