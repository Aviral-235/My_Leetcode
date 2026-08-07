class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max=0;
        for(int x:piles){
            max=Math.max(max,x);
        }
        int l=1;
        int hl=max;
        int ans=0;
        while(l<=hl){
            int mid=(l+hl)/2;
            if(possible(piles,mid,h)){
                ans=mid;
                hl=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return ans;
    }
    public boolean possible(int arr[],int k,int h){
        int ceil=0;
        for(int x:arr){
            ceil+=(x+k-1)/k;
            if(ceil>h){
                return false;
            }
        }
        return true;
    }
}