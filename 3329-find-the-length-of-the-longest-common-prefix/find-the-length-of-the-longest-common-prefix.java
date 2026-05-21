class Solution {
    public void put(Set<Integer> set,int x){
        while(x>0){
            set.add(x);
            x/=10;
        }
    }
    public int check(Set<Integer> set,int x){
        while(x>0){
            if(set.contains(x)){
                return len(x);
            }
            x/=10;
        }
        return 0;
    } 
        public int len(int x){
            int count=0;
            while(x>0){
                count++;
                x/=10;
            }
            return count;
        }
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Set<Integer> set=new HashSet<>();
        for(int x:arr1){
            put(set,x);
        }
        int maxLen=0;
        for(int x:arr2){
            maxLen=Math.max(maxLen,check(set,x));
        }
        return maxLen;
    }
}