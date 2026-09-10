class Solution {
    public class Pair{
        int idx,num;
        Pair(int idx,int num){
            this.idx=idx;
            this.num=num;
        }
    }
    public int largestRectangleArea(int[] heights) {
        Stack<Pair> st=new Stack<>();
        int maxArea=0;
        for(int i=0;i<heights.length;i++){
            while(!st.isEmpty()&&st.peek().num>heights[i]){
                Pair curr=st.pop();
                int num=curr.num;
                int pseIdx=-1;
                if(!st.isEmpty()){
                    pseIdx=st.peek().idx;
                }
                int nseIdx=i;
                int area=num*(nseIdx-pseIdx-1);
                maxArea=Math.max(maxArea,area);
            }
            st.push(new Pair(i,heights[i]));
        }
        while(!st.isEmpty()){
            Pair curr=st.pop();
            int pseIdx=-1;
            if(st.isEmpty()==false){
                pseIdx=st.peek().idx;
            }
            int nseIdx=heights.length;
            int num=curr.num;
            int area=num*(nseIdx-pseIdx-1);
            maxArea=Math.max(maxArea,area);
        }
        return maxArea;
    }
}