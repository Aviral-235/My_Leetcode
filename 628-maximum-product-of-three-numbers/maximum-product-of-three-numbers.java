class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        return Math.max((nums[n-1]*nums[n-2]*nums[n-3]),(nums[n-1]*nums[0]*nums[1]));
        // List<Integer> list=new ArrayList<>();
        // if(nums.length<5){
        //     return nums[nums.length-1]*nums[nums.length-2]*nums[nums.length-3];
        // }
        // list.add(nums[nums.length-1]);
        // list.add(nums[nums.length-2]);
        // list.add(nums[nums.length-3]);
        // list.add(nums[0]);
        // list.add(nums[1]);
        // Collections.sort(list);
        // return Math.max((list.get(list.size()-1)*list.get(list.size()-2)*list.get(list.size()-3)),(list.get(list.size()-1)*list.get(0)*list.get(1)));
    }
}