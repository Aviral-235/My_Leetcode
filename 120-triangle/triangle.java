class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int minpath=0;
        for(int i=triangle.size()-2;i>=0;i--){
            for(int j=0;j<=i;j++){
                int lowerleft=triangle.get(i+1).get(j);
                int lowerright=triangle.get(i+1).get(j+1);
                    minpath=triangle.get(i).get(j)+Math.min(lowerleft,lowerright);
                triangle.get(i).set(j,minpath);
            }
        }
        return triangle.get(0).get(0);
    }
}
