class Solution {
    public int totalFruit(int[] fruits) {
        int max=0;
        for(int i=0;i<fruits.length;i++){
            if(fruits[i]>max){
                max=fruits[i];
            }
        }
        int freq[]=new int[max+1];
        
        int j=0;
        int maxLen=0;
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<fruits.length;i++){
            set.add(fruits[i]);
            freq[fruits[i]]++;
            while(set.size()>2){
                freq[fruits[j]]--;
                if(freq[fruits[j]]==0){
                    set.remove(fruits[j]);
                }
                j++;
            }
            maxLen=Math.max(maxLen,i-j+1);
        }
        return maxLen;
    }
}