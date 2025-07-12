class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0; // No houses
        if (nums.length == 1) return nums[0]; // Only one house

        int prevRob = nums[0]; // Rob first house
        int prevSkip = 0;      // Skip first house

        for (int i = 1; i < nums.length; i++) {
            int newRob = prevSkip + nums[i];            // Rob current house
            prevSkip = Math.max(prevSkip, prevRob);     // Max if we skip current
            prevRob = newRob;                           // Update rob value
        }

        return Math.max(prevRob, prevSkip); // Max of robbing or skipping last house
    }
}
