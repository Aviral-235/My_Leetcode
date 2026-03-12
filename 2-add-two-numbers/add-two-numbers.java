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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int rem = 0;
        ListNode curr1 = l1;
        ListNode curr2 = l2;
        
        int firstSum = curr1.val + curr2.val;
        ListNode head = new ListNode(firstSum % 10);
        ListNode res = head;
        rem = firstSum / 10;
        
        curr1 = curr1.next;
        curr2 = curr2.next;

        while (curr1 != null && curr2 != null) {
            int currentSum = curr1.val + curr2.val + rem;
            head.next = new ListNode(currentSum % 10);
            head = head.next;
            rem = currentSum / 10;
            curr1 = curr1.next;
            curr2 = curr2.next;
        }

        while (curr1 != null) {
            int currentSum = curr1.val + rem;
            head.next = new ListNode(currentSum % 10);
            head = head.next;
            rem = currentSum / 10;
            curr1 = curr1.next;
        }

        while (curr2 != null) {
            int currentSum = curr2.val + rem;
            head.next = new ListNode(currentSum % 10);
            head = head.next;
            rem = currentSum / 10;
            curr2 = curr2.next;
        }

        if (rem > 0) {
            head.next = new ListNode(rem);
        }

        return res;
    }
}