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
        if (head == null || head.next == null || k == 0) return head;

        // 1. Calculate the length and find the tail
        ListNode tail = head;
        int length = 1;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        // 2. Close the loop (make it circular)
        tail.next = head;

        // 3. Find the new break point
        // Rotating by k is the same as rotating by k % length
        k = k % length;
        int stepsToNewTail = length - k;
        
        ListNode newTail = tail; 
        while (stepsToNewTail-- > 0) {
            newTail = newTail.next;
        }

        // 4. Break the loop and set the new head
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}
