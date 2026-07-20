class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int prefix_xor[]=new int[arr.length];
        prefix_xor[0]=arr[0];
        for(int i=1;i<prefix_xor.length;i++){
            prefix_xor[i]=prefix_xor[i-1]^arr[i];
        }
        int ans[]=new int[queries.length];
        int x=0;
        for(int edge[]:queries){
            int l=edge[0];
            int r=edge[1];
            if(l==0){
                ans[x]=prefix_xor[r];
                x++;
                continue;
            }
            ans[x]=prefix_xor[r]^prefix_xor[l-1];
            x++;
        }
        return ans;
    }
}