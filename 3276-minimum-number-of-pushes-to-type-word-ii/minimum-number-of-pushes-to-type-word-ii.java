class Solution {
    public int minimumPushes(String word) {
        int arr[]=new int[26];
        for(int i=0;i<word.length();i++){
            char c=word.charAt(i);
            arr[c-'a']++;
        }
        Arrays.sort(arr);
        for(int i=0;i<arr.length/2;i++){
            int temp=arr[i];
            arr[i]=arr[arr.length-i-1];
            arr[arr.length-i-1]=temp;
        }
        int res=0;
        int charCount=0;
        for(int i=0;i<26;i++){
            if(arr[i]!=0){
                charCount++;
            }
            int pushes= 0;
            if(charCount%8==0){
                pushes=charCount/8;
            }
            else{
                pushes=(charCount/8)+1;
            }
            res+=arr[i]*pushes;
        }
        return res;
    }
}