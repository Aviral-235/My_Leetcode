class Solution {
    public static void sum(List<List<Integer>> ans,int k,int n,int start,List<Integer> list,int arr[]){
        if(k==0){
            if(n==0){
                ans.add(new ArrayList<>(list));
            }
                return;
        }
        if(n<0){
            return;
        }
        for(int i=start;i<arr.length;i++){
            list.add(arr[i]);
            sum(ans,k-1,n-arr[i],i+1,list,arr);
            list.remove(list.size()-1);
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        int arr[]=new int[9];
        for(int i=0;i<9;i++){
            arr[i]=i+1;
        }
        List<List<Integer>> ans=new ArrayList<>();
        sum(ans,k,n,0,new ArrayList<>(),arr);
        return ans;
    }
}