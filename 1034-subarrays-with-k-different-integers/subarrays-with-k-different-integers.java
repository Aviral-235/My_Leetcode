class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return count_(nums,k)-count_(nums,k-1);
    }
    public int count_(int arr[],int k){
        Map<Integer,Integer> mpp=new HashMap<>();
        int l=0;
        int r=0;
        int count=0;
        while(r<arr.length){
            mpp.put(arr[r],mpp.getOrDefault(arr[r],0)+1);
            while(mpp.size()>k){
                mpp.put(arr[l],mpp.getOrDefault(arr[l],0)-1);
                if(mpp.get(arr[l])==0){
                    mpp.remove(arr[l]);
                }
                l++;
            }
            count+=(r-l+1);
            r++;
        }
        return count;
    }
}