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
    public int size(ListNode head){
        int count=0;
        ListNode curr=head;
        while(curr!=null){
            count++;
            curr=curr.next;
        }
        return count;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0){
            return null;
        }
        int n=0;
        for(int i=0;i<lists.length;i++){
            n+=size(lists[i]);
        }
        int arr[]=new int[n];
        int j=0;
        for(int i=0;i<lists.length;i++){
            if(lists[i]==null){
                continue;
            }
            ListNode curr=lists[i];
            while(curr!=null){
                arr[j]=curr.val;
                j++;
                curr=curr.next;
            }
        }
        Arrays.sort(arr);
        if(arr.length==0){
            return null;
        }
        ListNode newhead=new ListNode(arr[0]);
        ListNode curr=newhead;
        
        for(int i=1;i<arr.length;i++){
            curr.next=new ListNode(arr[i]);
            curr=curr.next;
        }
        return newhead;
    }
}