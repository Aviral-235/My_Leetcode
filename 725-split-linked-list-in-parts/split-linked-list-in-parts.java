class Solution {
    public int size(ListNode head) {
        ListNode curr = head;
        int count = 0;
        while (curr != null) {
            curr = curr.next;
            count++;
        }
        return count;
    }

    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] res = new ListNode[k];
        int n = size(head);
        int width = n / k;
        int extra = n % k;

        ListNode curr = head;
        for (int i = 0; i < k; i++) {
            if (curr == null) break;
            
            res[i] = curr;
            int currentPartSize = width + (extra > 0 ? 1 : 0);
            extra--;

            for (int j = 0; j < currentPartSize - 1; j++) {
                curr = curr.next;
            }

            ListNode nextPart = curr.next;
            curr.next = null;
            curr = nextPart;
        }
        return res;
    }
}