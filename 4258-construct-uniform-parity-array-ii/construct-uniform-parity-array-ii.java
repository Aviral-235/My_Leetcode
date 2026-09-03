class Solution {
    public boolean uniformArray(int[] nums1) {
        int even=Integer.MAX_VALUE;
        int odd=Integer.MAX_VALUE;
        boolean evenParity=true;
        boolean oddParity=true;
        int ct_odd=0;
        for(int x:nums1){
            if(x%2==0){
                even=Math.min(even,x);
            }
            else{
                ct_odd++;
                odd=Math.min(odd,x);
            }
        }
        if(ct_odd==0){
            return true;
        }
    

    for(int x:nums1){
        if(x%2==0&&odd>x){
            oddParity=false;
        }
    }
    return oddParity;
    }
}