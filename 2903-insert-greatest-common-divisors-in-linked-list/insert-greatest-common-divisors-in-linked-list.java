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
    public static int gethcf(int a, int b) {
        while (b != 0) {
            int remainder = a % b;
            a = b;
            b = remainder;
        }
        return a;
    }
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if(head.next==null){
            return head;
        }
        ListNode curr=head;
        while(curr!=null && curr.next!=null){
            ListNode temp= new ListNode(gethcf(curr.val,curr.next.val));
            temp.next=curr.next;
            curr.next=temp;
            curr=temp.next;
        }
        return head;
    }
}