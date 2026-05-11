class Solution {
    public void convert(int x,List<Integer> list){
        while(x>0){
            int rem=x%10;
            list.add(rem);
            x/=10;
        }
        Collections.reverse(list);
    }
    public int[] separateDigits(int[] nums) {
        List<Integer> list_new=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            List<Integer> list=new ArrayList<>();
            convert(nums[i],list);
            for(int j=0;j<list.size();j++){
                list_new.add(list.get(j));
            }
        }
        int arr[]=new int[list_new.size()];
        for(int i=0;i<arr.length;i++){
            arr[i]=list_new.get(i);
        }
        return arr;
    }
}