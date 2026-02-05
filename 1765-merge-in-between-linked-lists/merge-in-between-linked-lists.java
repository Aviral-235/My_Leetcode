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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode start= list1;
        ListNode end=list1;
        int i=0;
        int j=0;
        while(i<b){
            end=end.next;
            i++;
        }
        while(j<a-1){
            start=start.next;
            j++;
        }
        start.next=list2;
       while(list2.next!=null){
        list2=list2.next;
       }
       list2.next=end.next;
       return list1;
    }
}