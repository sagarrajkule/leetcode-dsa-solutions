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
        // Edge case: if list array is null or empty, return null
        if (lists == null || lists.length == 0)
            return null;

        // Create a min-heap (PriorityQueue) that compares nodes by their value
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(
                (a, b) -> Integer.compare(a.val, b.val));

        // Add the head of each non-null list to the min-heap
        for (ListNode node : lists) {
            if (node != null) {
                minHeap.offer(node);
            }
        }

        // Dummy node to start building the result list
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        // Continue extracting the smallest node until the heap is empty
        while (!minHeap.isEmpty()) {
            // Get the smallest node from the heap
            ListNode smallest = minHeap.poll();

            // Append it to the result list
            current.next = smallest;
            current = current.next;

            // If there’s a next node in the same list, push it into the heap
            if (smallest.next != null) {
                minHeap.offer(smallest.next);
            }
        }

        // Return the merged list starting from the next of dummy
        return dummy.next;
    }
}