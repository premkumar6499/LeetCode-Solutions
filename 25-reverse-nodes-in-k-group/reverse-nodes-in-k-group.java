class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode prevGroupTail = dummy;
        
        while (true) {
            // 1. Check if there are at least k nodes left
            ListNode kthNode = getKthNode(prevGroupTail, k);
            if (kthNode == null) break;
            
            ListNode nextGroupHead = kthNode.next;
            
            // 2. Reverse the k nodes
            ListNode curr = prevGroupTail.next;
            ListNode prev = nextGroupHead; // Point the first node of the group to the next group's head
            
            for (int i = 0; i < k; i++) {
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }
            
            // 3. Connect the previous part to the new head of this reversed group
            ListNode tempTail = prevGroupTail.next; // This was the head, now it's the tail
            prevGroupTail.next = kthNode;
            prevGroupTail = tempTail;
        }
        
        return dummy.next;
    }

    private ListNode getKthNode(ListNode curr, int k) {
        while (curr != null && k > 0) {
            curr = curr.next;
            k--;
        }
        return curr;
    }
}