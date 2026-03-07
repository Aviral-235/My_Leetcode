class Solution {
    public int[] countPoints(int[][] points, int[][] queries) {
        int []res= new int[queries.length];
        for(int i=0;i<queries.length;i++){
            int count=0;
            for(int j=0;j<points.length;j++){
                int x= ((points[j][0]-queries[i][0])*(points[j][0]-queries[i][0]))+((points[j][1]-queries[i][1])*(points[j][1]-queries[i][1]))-(queries[i][2]*queries[i][2]);
                if(x<=0){
                    count++;
                }
            }
                res[i]=count;
        }
        return res;
    }
}