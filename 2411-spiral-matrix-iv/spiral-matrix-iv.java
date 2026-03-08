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
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int arr[][]=new int[m][n];
        ListNode curr=head;
        int top=0;
        int bottom=m-1;
        int left=0;
        int right=n-1;
        while(top<=bottom&&left<=right){
            for(int i=left;i<=right;i++){
                if(curr==null){
                    arr[top][i]=-1;
                }
                else{
                    arr[top][i]=curr.val;
                    curr=curr.next;
                }
                
            }
            top++;
            for(int i=top;i<=bottom;i++){
                if(curr==null){
                    arr[i][right]=-1;
                }
                else{
                    arr[i][right]=curr.val;
                    curr=curr.next;
                }
                
            }
            right--;
            if(bottom>=top){
                for(int i=right;i>=left;i--){
                    if(curr==null){
                        arr[bottom][i]=-1;
                    }
                    else{
                        arr[bottom][i]=curr.val;
                        curr=curr.next;
                    }
                }
                bottom--;
            }
            if(right>=left){
            for (int i = bottom; i >= top; i--) {
                if(curr==null){
                    arr[i][left]=-1;
                }
                else{
                    arr[i][left]=curr.val;
                    curr=curr.next;
                }
                }
                 left++;
            }
           
        }
        return arr;
    }
}