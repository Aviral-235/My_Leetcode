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
 import java.util.*;
class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set=new HashSet<>();
        for(int x: nums){
            set.add(x);
        }
        while(set.contains(head.val)){
            head=head.next;
        }
        ListNode curr=head.next;
        ListNode temp=head;
        while(curr!=null){
            if(set.contains(curr.val)){
                temp.next=curr.next;
                curr=temp.next;
                continue;
            }

            temp=temp.next;
            curr=curr.next;
        }
        return head;
    }
}