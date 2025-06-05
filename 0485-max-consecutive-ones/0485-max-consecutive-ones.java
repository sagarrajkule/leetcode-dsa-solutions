class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int current = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                current++;
                max = Math.max(max, current);
            } else {
                current = 0;
            }
        }

        return max;
    }
}
