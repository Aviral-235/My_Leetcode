class Solution {
    public List<List<Integer>> subset(int[] arr,int n,List<Integer> list,List<List<Integer>> ans){
        if(n<0){
            ans.add(new ArrayList<>(list));
            return ans;
        }
        list.add(arr[n]);
        subset(arr,n-1,list,ans);
        list.remove(list.size()-1);
        while(n>0&&arr[n]==arr[n-1]){
            n--;
        }
        subset(arr,n-1,list,ans);
        return ans;
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<Integer> list=new ArrayList<>();
        List<List<Integer>> ans=new ArrayList<>();
        int n=nums.length-1;
        return subset(nums,n,list,ans);
    }
}