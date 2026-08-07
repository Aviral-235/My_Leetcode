class Solution {
    public int shipWithinDays(int[] weights, int days) {
      int max=0;
      int min=0;
        for(int x:weights){
            max+=x;
             min=Math.max(min,x);
        }
        int l=min;
        int h=max;
        int ans=0;
        while(l<=h){
            int mid=(l+h)/2;
            if(possible(weights,mid,days)){
                ans=mid;
                h=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return ans;  
    }
    public boolean possible(int arr[],int cap,int days){
        int currLoad=0;
        int count=1;
        for(int x:arr){
            if(currLoad+x>cap){
                count++;
                currLoad=x;
            }
            else{
                currLoad+=x;
            }
            if(count>days){
                return false;
            }
        }
        return true;
    }
}