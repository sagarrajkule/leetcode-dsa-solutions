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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Dummy node to simplify result list creation
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;

        int carry = 0; // Carry for sum > 9

        // Loop through both lists until both are null
        while (l1 != null || l2 != null || carry != 0) {
            int val1 = (l1 != null) ? l1.val : 0; // Get value from l1 or 0
            int val2 = (l2 != null) ? l2.val : 0; // Get value from l2 or 0

            int sum = val1 + val2 + carry; // Sum of current digits + carry
            carry = sum / 10; // Update carry for next node
            int digit = sum % 10; // Get the last digit

            current.next = new ListNode(digit); // Add new node to result
            current = current.next;

            // Move to next nodes if they exist
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }

        // Return the next of dummy as the result list head
        return dummyHead.next;
    }
}
