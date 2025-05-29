class Solution {
    public int findMin(int[] nums) {
        int n = nums.length; // use .length instead of .size()
        int low = 0;
        int high = n - 1;

        while (low < high) {
            int mid = (low + high) / 2;

            // 2nd part is unsorted
            if (nums[mid] > nums[high]) {
                low = mid + 1;
            }
            // Second part is sorted
            else {
                high = mid;
            }
        }

        return nums[low];
    }
}