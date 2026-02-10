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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null||head.next==null){
            return null;
        }
        int len=0;
        ListNode curr= head;
        while(curr!=null){
            len++;
            curr=curr.next;
        }
        if(n==len){
            head=head.next;
            return head;
        }
        int x= len-n;
        curr=head;
        while(x>1){
            curr=curr.next;
            x--;
        }
        curr.next=curr.next.next;
        return head;
    }
}