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
    public ListNode swapNodes(ListNode head, int k) {
        int n=0;
        ListNode curr=head;
        while(curr!=null){
            curr=curr.next;
            n++;
        }
        curr=head;
            ListNode arr[]=new ListNode[n];
            for(int i=0;i<n;i++){
                arr[i]=curr;
                curr=curr.next;
            }
            ListNode temp=arr[k-1];
            arr[k-1]=arr[n-k];
            arr[n-k]=temp;
        head=arr[0];
        curr=head;
        for(int i=1;i<n;i++){
            curr.next=arr[i];
            curr=curr.next;
        }
        curr.next=null;
        return head;
        }
}