class Solution {
    public int missingMultiple(int[] nums, int k) {
        Set<Integer> set=new HashSet<>();
        for(int x:nums){
            set.add(x);
        }
        int fact=1;
        while(set.contains(fact*k)){
            fact++;
        }
        return fact*k;
    }
}