import java.util.PriorityQueue;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> ans = new PriorityQueue<>(); // Min-heap to store k largest elements

        for (int i = 0; i < nums.length; i++) {
            ans.add(nums[i]);
            if (ans.size() > k) {
                ans.poll(); // Remove the smallest element to keep only k largest
            }
        }

        return ans.peek(); // Return the top of the heap, which is the kth largest
    }
}
