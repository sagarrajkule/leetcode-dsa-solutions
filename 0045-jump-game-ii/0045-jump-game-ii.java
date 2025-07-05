class Solution {
    public int jump(int[] nums) {
        int jumps = 0;          // Number of jumps made
        int end = 0;            // End of the current jump range
        int farthest = 0;       // Farthest index reachable in the current range

        // Traverse the array from start to second-last index
        for (int i = 0; i < nums.length - 1; i++) {
            // Update the farthest we can reach from this index
            farthest = Math.max(farthest, i + nums[i]);

            // If we reach the end of the current jump range
            if (i == end) {
                jumps++;        // Make a jump
                end = farthest; // Set new jump range end
            }
        }

        // Return the minimum number of jumps to reach the last index
        return jumps;
    }
}
