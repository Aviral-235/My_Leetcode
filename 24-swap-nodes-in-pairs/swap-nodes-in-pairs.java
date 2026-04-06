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
    public ListNode swapPairs(ListNode head) {
        if(head==null){
            return null;
        }
        if(head.next==null){
            return head;
        }
        // if(head.next.next==null){
        //     int val_=head.val;
        //     head.val=head.next.val;
        //     head.next.val=val_;
        //     return 
        // }
        ListNode curr=head;
        while(curr!=null&&curr.next!=null){
            int val_=curr.val;
            curr.val=curr.next.val;
            curr.next.val=val_;
            curr=curr.next.next;
        }
        return head;
    }
}