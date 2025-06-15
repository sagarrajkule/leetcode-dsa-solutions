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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Create a dummy node to simplify edge cases
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        // Traverse both lists until one runs out
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1; // Append list1 node
                list1 = list1.next;   // Move list1 ahead
            } else {
                current.next = list2; // Append list2 node
                list2 = list2.next;   // Move list2 ahead
            }
            current = current.next;   // Move current pointer
        }

        // Attach the remaining nodes (one of these will be null)
        current.next = (list1 != null) ? list1 : list2;

        return dummy.next; // The real head is after the dummy
    }
}
