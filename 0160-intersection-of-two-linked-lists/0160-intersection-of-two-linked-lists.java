/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // If either list is empty, there can be no intersection
        if (headA == null || headB == null) {
            return null;
        }

        // Use two pointers to traverse both lists
        ListNode pointerA = headA;
        ListNode pointerB = headB;

        // Traverse both lists; when either pointer reaches the end,
        // switch it to the start of the other list
        // Eventually they will meet at the intersection or both will be null
        while (pointerA != pointerB) {
            pointerA = (pointerA == null) ? headB : pointerA.next;
            pointerB = (pointerB == null) ? headA : pointerB.next;
        }

        // Either the intersection node or null if no intersection
        return pointerA;
    }
}
