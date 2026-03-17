class Solution {
    public int firstMissingPositive(int[] nums) {
        int start=0;
        Arrays.sort(nums);
        Set<Integer> set=new HashSet<>();
        while(start<nums.length&&nums[start]<0){
            start++;
        }
        if(start>=nums.length){
            return 1;
        }
        if(nums[start]==0){
            start++;
        }
        int check=1;
        for(int i=start;i<nums.length;i++){
            set.add(nums[i]);
        }
        while(set.size()>0){
            if(set.contains(check)){
                set.remove(check);
                check++;
            }
            else{
                return check;
            }
        }
        return check;
    }
}