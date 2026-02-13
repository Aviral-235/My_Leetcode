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
    public int pairSum(ListNode head) {
        
        Deque<Integer> st=new ArrayDeque<>();
        ListNode curr=head;
        int n=0;
        while(curr!=null){
            st.push(curr.val);
            curr=curr.next;
        }
        curr=head;
        int res=0;
        int size=st.size();
        for(int i=0;i<=size/2;i++){
            res=Math.max(res,curr.val+st.poll());
            curr=curr.next;
        }
            return res;
    }
}