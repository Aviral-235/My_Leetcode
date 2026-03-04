class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> res=new ArrayList<>();
        int j=0;
        for(int i=1;i<=n;i++){
            if(target[j]==i){
                res.add("Push");
                j++;
                if(j==target.length){
                    break;
                }
            }
            else{
                    res.add("Push");
                    res.add("Pop");
            }
        }
        return res;
    }
}