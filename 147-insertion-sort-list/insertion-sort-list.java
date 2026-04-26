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
    public ListNode insertionSortList(ListNode head) {
        ListNode curr=head;
        List<Integer> list=new ArrayList<>();
        while(curr!=null){
            list.add(curr.val);
            curr=curr.next;
        }
        Collections.sort(list);
        ListNode new_head=new ListNode(list.get(0));
        curr=new_head;
        for(int i=1;i<list.size();i++){
            curr.next=new ListNode(list.get(i));
            curr=curr.next;
        }
        return new_head;
    }
}