class Solution {
    int count=0;
    public void mergeSort(int arr[],int l,int h){
        if(l<h){
            int mid=(l+h)/2;
            mergeSort(arr,l,mid);
            mergeSort(arr,mid+1,h);
            countPairs(arr,l,mid,h);
            merge(arr,l,mid,h);
        }
    }
    public void countPairs(int arr[], int l, int mid, int h) {
    int right = mid + 1;
    for (int i = l; i <= mid; i++) {
        while (right <= h && (long) arr[i] > 2L * arr[right]) {
            right++;
        }
        count += right - (mid + 1);
    }
}
    public void merge(int arr[],int low,int mid,int high){
         List<Integer> temp = new ArrayList<>();
        int left= low;
        int right= mid+1;
        while(left<=mid && right<=high){
            if(arr[left]<=arr[right]){
               temp.add(arr[left]); 
               left++;
            }
            else{
                temp.add(arr[right]);
                right++;
            }
            
        }
            while(left<=mid){
                temp.add(arr[left]);
                left++;
            }
            while(right<=high){
                temp.add(arr[right]);
                right++;
            }
            for(int i= low; i<=high;i++){
                arr[i]= temp.get(i-low);
            }
    }
    public int reversePairs(int[] nums) {
        mergeSort(nums,0,nums.length-1);
        return count;
    }
}