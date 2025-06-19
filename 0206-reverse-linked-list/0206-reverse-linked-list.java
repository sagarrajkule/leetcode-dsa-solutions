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
    public ListNode reverseList(ListNode head) {
        // If list is empty or has only one node, return head
        if (head == null || head.next == null) {
            return head;
        }

        // Initialize previous and current pointers
        ListNode prev = null;
        ListNode current = head;

        // Iterate through the list and reverse the pointers
        while (current != null) {
            ListNode nextNode = current.next; // Save next node
            current.next = prev; // Reverse current node's pointer
            prev = current; // Move prev forward
            current = nextNode; // Move current forward
        }

        // At the end, prev will point to the new head
        return prev;
    }
}