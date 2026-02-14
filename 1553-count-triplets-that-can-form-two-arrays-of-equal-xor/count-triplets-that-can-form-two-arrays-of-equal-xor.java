class Solution {
    public int countTriplets(int[] arr) {
        if(arr.length<2){
            return 0;
        }
        int count=0;
        
       
        for(int i=0;i<arr.length-1;i++){
            int xor1=0;
            for(int j=i+1;j<arr.length;j++){
                 xor1^=arr[j-1];
                  int xor2=0;
                for(int k=j;k<arr.length;k++){
                    xor2^=arr[k];
                    if(xor1==xor2){
                        count++;
                    }
                }
            }
        }
        return count;
    }
}