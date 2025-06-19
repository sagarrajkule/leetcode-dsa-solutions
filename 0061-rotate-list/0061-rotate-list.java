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
        // Edge cases: empty list or single node or zero rotation
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // Step 1: Count the length of the list and get the last node
        int length = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        // Step 2: Calculate effective rotations needed
        k = k % length;
        if (k == 0)
            return head; // No rotation needed

        // Step 3: Find the new tail: (length - k - 1)th node
        ListNode newTail = head;
        for (int i = 1; i < length - k; i++) {
            newTail = newTail.next;
        }

        // Step 4: Set the new head and rearrange pointers
        ListNode newHead = newTail.next;
        newTail.next = null;
        tail.next = head;

        return newHead;
    }
}