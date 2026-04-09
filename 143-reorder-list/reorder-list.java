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
    public void reorderList(ListNode head) {
        int count=0;
        ListNode curr=head;
        while(curr!=null){
            curr=curr.next;
            count++;
        }
        int last=count/2;
        curr=head;
        Deque<ListNode> st=new ArrayDeque<>();
        int size=count;
        for(int i=0;i<size;i++){
            if(count<=last){
                st.add(curr);
            }
            curr=curr.next;
            count--;
        }
        curr=head;
        while(st.isEmpty()==false){
            ListNode insert=st.pollLast();
            insert.next=curr.next;
            curr.next=insert;
            curr=insert.next;
        }
        if(curr.next!=null){
        curr.next=null;
        }
    }
}