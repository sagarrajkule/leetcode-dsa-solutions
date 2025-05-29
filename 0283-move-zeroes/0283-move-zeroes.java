class Solution {
    public void moveZeroes(int[] nums) {
        int count = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                nums[count] = nums[i];
                count++;
            }
        }
        while (count < n) {
            nums[count] = 0;
            count++;
        }
    }
}