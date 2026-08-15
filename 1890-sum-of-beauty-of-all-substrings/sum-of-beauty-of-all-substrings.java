class Solution {
    public int beautySum(String s) {
        int sum=0;
        
        for(int i=0;i<s.length();i++){
            int freq[]=new int[26];
            for(int j=i;j<s.length();j++){
                freq[s.charAt(j)-'a']++;
                int max=findMax(freq);
                int min=findMin(freq);
                if(min==Integer.MAX_VALUE){
                    continue;
                }
                sum+=max-min;
            }
        }
        return sum;
    }
    public int findMin(int arr[]){
        int min=Integer.MAX_VALUE;
        for(int x:arr){
            if(x!=0){
                min=Math.min(min,x);
            }
        }
        return min;
    }
    public int findMax(int arr[]){
        int max=0;
        for(int x:arr){
        
                max=Math.max(max,x);
            
        }
        return max;
    }
}