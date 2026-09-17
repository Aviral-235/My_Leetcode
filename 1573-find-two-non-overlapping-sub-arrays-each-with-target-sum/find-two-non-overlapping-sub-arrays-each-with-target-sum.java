class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int minIdx[]=new int[arr.length];
        Arrays.fill(minIdx,Integer.MAX_VALUE);
        int ans=Integer.MAX_VALUE;
        int sum=0;
        int i=0;
        int j=0;
        while(i<arr.length){
            sum+=arr[i];
            while(sum>target){
                sum-=arr[j];
                j++;
            }
            if(sum==target){
                int len=i-j+1;
                if(j>0&&minIdx[j-1]!=Integer.MAX_VALUE){
                    ans=Math.min(ans,len+minIdx[j-1]);    
                }
                if(i>0){
                minIdx[i]=Math.min(len,minIdx[i-1]);
                }
                else{
                    minIdx[i]=len;
                }
                    
                
                
            }
            else{
                if(i>0){
                    minIdx[i]=minIdx[i-1];
                }
            }
            i++;
        }
        if(ans==Integer.MAX_VALUE){
            return -1;
        }
        return ans;
    }
}