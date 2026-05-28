class Solution {
    public int findIdx(List<Integer> temp,int x){
        int idx=0;
        for(int i=0;i<temp.size();i++){
            if(temp.get(i)==x){
                idx=i;
                int moved=temp.remove(i);
                temp.add(0,moved);
                break;
            }
        }
        return idx;
    }
    public int[] processQueries(int[] queries, int m) {
        int arr[]=new int[queries.length];
        List<Integer> temp=new ArrayList<>();
        for(int i=0;i<m;i++){
            temp.add(i+1);
        }
        for(int i=0;i<queries.length;i++){
            arr[i]=findIdx(temp,queries[i]);
        }
        return arr;
    }
}