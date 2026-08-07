class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int max=0;
        for(int x:nums){
            max=Math.max(x,max);
        }
        int l=1;
        int h=max;
        int ans=0;
        while(l<=h){
            int mid=(l+h)/2;
            if(possible(nums,mid,threshold)){
                ans=mid;
                h=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return ans;
    }
    public boolean possible(int arr[],int div,int maxsum){
        int ceil=0;
        for(int x:arr){
            ceil+=(x+div-1)/div;
            if(ceil>maxsum){
                return false;
            }
        }
        return true;
    }
}