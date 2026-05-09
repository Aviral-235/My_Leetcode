class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer,Integer> map=new HashMap<>();
        int max=0;
        for(int i=0;i<wall.size();i++){
            int edgecount=0;
            List<Integer> row=wall.get(i);
            for(int j=0;j<row.size()-1;j++){
                edgecount+=row.get(j);
                int curr=map.getOrDefault(edgecount,0)+1;
                map.put(edgecount,curr);
                max=Math.max(max,curr);
            }
        }
        return wall.size()-max;
    }
}