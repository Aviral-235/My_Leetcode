class Solution {
    public int largestInteger(int[] nums, int k) {
        int ctIdxFirst=0;
        int ctIdxLast=0;
        int max=0;
        if(k==1){
            List<Integer> list=new ArrayList<>();
            Set<Integer> set=new HashSet<>();
            for(int x:nums){
                if(set.contains(x)){
                    list.remove(Integer.valueOf(x));
                }
                else{
                    list.add(x);
                }
                set.add(x);
            }
            if(list.size()==0){
                return -1;
            }
            Collections.sort(list);
            return list.get(list.size()-1);
        }
        if(k==nums.length){
            for(int x:nums){
                max=Math.max(max,x);
            }
            return max;
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]==nums[0]){
                ctIdxFirst++;
            }
            if(nums[i]==nums[nums.length-1]){
                ctIdxLast++;
            }
        }
        if(ctIdxFirst==1&&ctIdxLast>1){
            return nums[0];
        }
        if(ctIdxFirst>1&&ctIdxLast==1){
            return nums[nums.length-1];
        }
        if(ctIdxFirst==1&&ctIdxLast==1){
            return Math.max(nums[0],nums[nums.length-1]);
        }
        return -1;
    }
}