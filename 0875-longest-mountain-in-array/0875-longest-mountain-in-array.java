class Solution {
    public int longestMountain(int[] arr) {
        int n = arr.length;
        if (n < 3) return 0;

        int ans = 0;

        for (int i = 1; i < n - 1; i++) {
            // Check if it's a peak
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                int left = i;
                int right = i;

                // Move left pointer to start of the mountain
                while (left > 0 && arr[left - 1] < arr[left]) {
                    left--;
                }

                // Move right pointer to end of the mountain
                while (right < n - 1 && arr[right] > arr[right + 1]) {
                    right++;
                }

                // Update the answer
                ans = Math.max(ans, right - left + 1);

                // Optimization: skip checked mountain
                i = right;
            }
        }

        return ans;
    }
}