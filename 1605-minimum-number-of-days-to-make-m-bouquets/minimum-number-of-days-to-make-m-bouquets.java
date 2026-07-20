class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int minday=Integer.MAX_VALUE;
        int maxday=Integer.MIN_VALUE;
        int h=0;
        int l=0;
        int res=-1;
        if((long)m*k>bloomDay.length){
            return -1;
        }
        for(int i=0;i<bloomDay.length;i++){
            if(bloomDay[i]<minday){
                minday=bloomDay[i];
                l=minday;
            }

            if(bloomDay[i]>maxday){
                maxday=bloomDay[i];
                h=maxday;
            }
        }
        while(l<=h){
            int mid=(h+l)/2;
            if(possible(bloomDay,mid,m,k)){
                res=mid;
                h=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return res;
    }
    public boolean possible(int arr[],int day,int m,int k){
        int bouquets=0;
        int count=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<=day){
                count++;
                if(count==k){
                    bouquets++;
                    count=0;
                }
            }
            else{
                count=0;
            }
        }
        return bouquets>=m;
    }
}