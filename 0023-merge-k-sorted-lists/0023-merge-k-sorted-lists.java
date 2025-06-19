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
    public ListNode mergeKLists(ListNode[] lists) {
        // If the input array is empty, return null as there's nothing to merge
        if (lists.length == 0) {
            return null;
        }

        // If the input array has only one list, return it directly (but your code currently returns null)
        if (lists.length == 1) {
            return lists[0]; // FIXED: should return lists[0], not null
        }

        // Merge the first two lists initially
        ListNode merged = mergeTwoLists(lists[0], lists[1]);

        // Iteratively merge the result with the remaining lists
        for (int i = 2; i < lists.length; i++) {
            merged = mergeTwoLists(merged, lists[i]);
        }

        // Return the final merged sorted list
        return merged;
    }

    // Merge Two Sorted Lists
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Create a dummy node to simplify edge cases
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        // Traverse both lists until one runs out
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1; // Append list1 node
                list1 = list1.next; // Move list1 ahead
            } else {
                current.next = list2; // Append list2 node
                list2 = list2.next; // Move list2 ahead
            }
            current = current.next; // Move current pointer
        }

        // Attach the remaining nodes (one of these will be null)
        current.next = (list1 != null) ? list1 : list2;

        return dummy.next; // The real head is after the dummy
    }
}