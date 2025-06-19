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
        // Edge cases: empty list, single node, or no rotation needed
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // Step 1: Determine the length of the list and get the last node
        int length = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        // Step 2: Make the list circular
        tail.next = head;

        // Step 3: Compute effective rotation steps
        k = k % length;
        int stepsToNewTail = length - k;

        // Step 4: Find the new tail node
        ListNode newTail = tail;
        while (stepsToNewTail-- > 0) {
            newTail = newTail.next;
        }

        // Step 5: Break the circle and set the new head
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}