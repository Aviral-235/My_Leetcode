class Solution {
    public static void sum(int[]arr,int n,int target,List<Integer> list,List<List<Integer>> ans){
        if(target==0){
            ans.add(new ArrayList<>(list));
            return;
        }
        if(target<0){
            return;
        }
        if(n<0){
            return;
        }
        list.add(arr[n]);
        sum(arr,n,target-arr[n],list,ans);
        list.remove(list.size()-1);
        sum(arr,n-1,target,list,ans);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        sum(candidates,candidates.length-1,target,new ArrayList<>(),ans);
        return ans;
    }
}