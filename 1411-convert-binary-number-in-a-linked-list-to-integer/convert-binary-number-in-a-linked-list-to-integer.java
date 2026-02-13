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
    public int getDecimalValue(ListNode head) {
        double n=0;
        long res=0;
        ListNode curr=head;
        while(curr!=null){
            n++;
            curr=curr.next;
        }
        curr=head;
        while(curr!=null){
            res+=(long)Math.pow(2.0,n-1)*curr.val;
            n--;
            curr=curr.next;
        }
        return (int)res;
    }
}