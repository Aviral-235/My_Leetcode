class Solution {
    public int minimumLength(String s) {
        int arr[]=new int[26];
        for(int i=0;i<s.length();i++){
            arr[s.charAt(i)-'a']++;
        }
        int output=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<3){
                output+=arr[i];
            }
            else{
               if(arr[i]%2==0){
                output+=2;
               }
               else{
                output++;
               }
            }
        }
        return output;
    }
}