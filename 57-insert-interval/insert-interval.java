class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<List<Integer>> temp=new ArrayList<>();
        int idx=0;
        while(idx<intervals.length&&intervals[idx][1]<newInterval[0]){
            List<Integer> list=new ArrayList<>();
            list.add(intervals[idx][0]);
            list.add(intervals[idx][1]);
            temp.add(list);
            idx++;
        }
        while(idx<intervals.length&&intervals[idx][0]<=newInterval[1]){
            newInterval[0]=Math.min(intervals[idx][0],newInterval[0]);
            newInterval[1]=Math.max(intervals[idx][1],newInterval[1]);
            idx++;
        }
        List<Integer> list=new ArrayList<>();
        list.add(newInterval[0]);
        list.add(newInterval[1]);
        temp.add(list);
        while(idx<intervals.length){
            List<Integer> l=new ArrayList<>();
            l.add(intervals[idx][0]);
            l.add(intervals[idx][1]);
            temp.add(l);
            idx++;
        }
        int ans[][]=new int[temp.size()][2];
        for(int i=0;i<ans.length;i++){
            ans[i][0]=temp.get(i).get(0);
            ans[i][1]=temp.get(i).get(1);
        }
        return ans;
    }
}