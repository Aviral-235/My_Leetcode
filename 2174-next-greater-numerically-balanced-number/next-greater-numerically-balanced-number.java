class Solution {
    public boolean balanced(int x){
        int arr[]=new int[10];
        while(x>0){
            int rem=x%10;
            arr[rem]++;
            x/=10;
        }
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=0&&arr[i]!=i){
                return false;
            }
        }
        return true;
    }
    public int nextBeautifulNumber(int n) {
        for(int i=n+1;i<1_000_000_000;i++){
            if(balanced(i)==true){
                return i;
            }
        }
        return -1;
    }
}