/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nextLargerNodes(ListNode head) {
        ListNode curr=head;
        int n=0;
        while(curr!=null){
            n++;
            curr=curr.next;
        }
        int arr[]=new int[n];
        int j=0;
        curr=head;
        while(curr!=null){
            arr[j]=curr.val;
            curr=curr.next;
            j++;
        }
            Deque<Integer> st=new ArrayDeque<>();
            int ans[]=new int[arr.length];
        for(int i=arr.length-1;i>=0;i--){
            while(!st.isEmpty()&& st.peek()<=arr[i]){
                st.pop();
            }
            if(st.isEmpty()==true){
                ans[i]=0;
            }
            else{
                ans[i]=st.peek();
            }
            st.push(arr[i]);
        }
        return ans;
    }
}