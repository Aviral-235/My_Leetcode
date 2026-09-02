class Solution {
    public boolean uniformArray(int[] nums1) {
        return allEven(nums1)||allOdd(nums1);
    }
    public boolean allEven(int nums1[]){
        for(int i=0;i<nums1.length;i++){
            boolean flag=false;
            if(nums1[i]%2==0){
                continue;
            }
            if(nums1[i]%2!=0){
                 for(int j=0;j<nums1.length;j++){
                    if(j==i){
                        continue;
                    }
                    if(nums1[j]%2==0||(nums1[i]-nums1[j])%2==0){
                        flag=true;
                        break;
                    }
                }        
                    }
            if(!flag){
            return false;
           }
        }
        return true;
    }
    public boolean allOdd(int nums1[]){
        for(int i=0;i<nums1.length;i++){
            boolean flag=false;
            if(nums1[i]%2!=0){
                continue;
            }
            if(nums1[i]%2==0){
                 for(int j=0;j<nums1.length;j++){
                    if(j==i){
                        continue;
                    }
                    if(nums1[j]%2!=0||(nums1[i]-nums1[j])%2!=0){
                        flag=true;
                        break;
                    }
                }        
                    }
            if(!flag){
            return false;
           }
        }
        return true;
    }
}