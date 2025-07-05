class Solution {
    public boolean canJump(int[] nums) {
        int target = nums.length - 1; // Target index we want to reach (initially the last index)

        // Traverse the array from end to start
        for (int i = nums.length - 1; i >= 0; i--) {
            // If from index i we can reach the current target or beyond,
            // then we update the target to be this index
            if (i + nums[i] >= target) {
                target = i;
            }
        }

        // If we were able to shift the target all the way to the start (index 0),
        // then we can reach the last index
        return target == 0;
    }
}
