class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Deque<Integer> st=new ArrayDeque<>();
        int res[]=new int[nums.length];
        Arrays.fill(res,-1);
        for(int i=2*nums.length-1;i>=0;i--){
            int curr=nums[i%nums.length];
            while(st.isEmpty()==false&&st.peek()<=curr){
                st.pop();
            }
            if(i<nums.length&&st.isEmpty()==false){
                res[i]=st.peek();
            }
            st.push(nums[i%nums.length]);
        }
        return res;
    }
}