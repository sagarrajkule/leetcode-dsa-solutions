class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int ans = 0, flip = 0;
        int start = 0, end = 0;

        while (end < n) {
            if (nums[end] == 0) {
                flip++;
            }

            while (flip > k) {
                if (nums[start] == 0) {
                    flip--;
                }
                start++;
            }
            ans = Math.max(ans, end - start + 1);
            end++;
        }
        return ans;
    }

}