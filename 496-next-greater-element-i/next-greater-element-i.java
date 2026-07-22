class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Deque<Integer> stack=new ArrayDeque<>();
        int res[]=new int[nums2.length];
        Arrays.fill(res,-1);
        for(int i=nums2.length-1;i>=0;i--){
            int curr=nums2[i];
            while(stack.isEmpty()==false&&stack.peek()<curr){
                stack.pop();
                    }
                    if(stack.isEmpty()==false){
                        res[i]=stack.peek();
                    }
                    stack.push(nums2[i]);
        }
        int ans[]=new int[nums1.length];
            for(int i=0;i<nums1.length;i++){
                int idx=search_idx(nums1[i],nums2);
                ans[i]=res[idx];
            }       
            return ans;
    }
    public int search_idx(int x,int arr[]){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==x){
                return i;
            }
        }
        return -1;
    }
}