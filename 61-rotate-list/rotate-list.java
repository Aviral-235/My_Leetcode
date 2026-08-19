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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null){
            return null;
        }
         List<Integer> list=new ArrayList<>();
         ListNode curr=head;
         while(curr!=null){
            list.add(curr.val);
            curr=curr.next;
         }
         k=k%list.size();
         while(k-->0){
            int prev=list.get(0);
            for(int i=1;i<list.size();i++){
                int x=list.get(i);
                list.set(i,prev);
                prev=x;
            }
            list.set(0,prev);
         }
        ListNode curr2=head;
        int idx=0;
        while(curr2!=null){
            curr2.val=list.get(idx);
            curr2=curr2.next;
            idx++;
        }
        return head;
    }
}