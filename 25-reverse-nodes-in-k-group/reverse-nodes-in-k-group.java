class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        // 1. Check if there are at least k nodes left to reverse
        ListNode curr = head;
        int count = 0;
        while (count < k && curr != null) {
            curr = curr.next;
            count++;
        }

        // If we found k nodes, reverse them
        if (count == k) {
            ListNode prev = null;
            ListNode next = null;
            ListNode tempCurr = head;
            
            // Standard reversal for exactly k nodes
            for (int i = 0; i < k; i++) {
                next = tempCurr.next;
                tempCurr.next = prev;
                prev = tempCurr;
                tempCurr = next;
            }

            // 2. 'head' is now the tail of this reversed segment.
            // Connect it to the result of the next recursive call (the next group).
            if (next != null) {
                head.next = reverseKGroup(next, k);
            }

            // 3. 'prev' is the new head of this reversed segment
            return prev;
        }

        // If fewer than k nodes remain, return head as-is (don't reverse)
        return head;
    }
}