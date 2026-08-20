class Solution {
    public int[] resultArray(int[] nums) {
        List<Integer> l1=new ArrayList<>();
        List<Integer> l2=new ArrayList<>();
        l1.add(nums[0]);
        l2.add(nums[1]);
        int p=0;
        int q=0;
        for(int i=2;i<nums.length;i++){
            if(l1.get(p)>l2.get(q)){
                l1.add(nums[i]);
                p++;
            }
            else{
                l2.add(nums[i]);
                q++;
            }
        }
        int idx=0;
        for(int i=0;i<l1.size();i++){
            nums[idx]=l1.get(i);
            idx++;
        }
        for(int i=0;i<l2.size();i++){
            nums[idx]=l2.get(i);
            idx++;
        }
        return nums;
    }
}