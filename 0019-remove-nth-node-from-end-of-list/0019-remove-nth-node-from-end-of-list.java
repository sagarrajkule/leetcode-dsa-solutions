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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Initialize two pointers starting at the head
        ListNode slow1 = head, slow2 = head;

        // Move the second pointer 'n' steps ahead
        for (int i = 0; i < n; i++) {
            slow2 = slow2.next;
        }

        // If slow2 is null, it means we are removing the first node (head)
        if (slow2 == null) {
            return head.next; // Remove the head node
        }

        // Move both pointers one step at a time until slow2 reaches the last node
        // This makes slow1 point to the node before the target node to remove
        while (slow2.next != null) {
            slow1 = slow1.next;
            slow2 = slow2.next;
        }

        // Skip the target node (nth from end) by updating the next pointer
        slow1.next = slow1.next.next;

        // Return the original head (unless it was removed)
        return head;
    }
}
