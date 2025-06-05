// class Solution {
//     public int trap(int[] height) {
//         int n = height.length;
//         if (n == 0) return 0;

//         int[] left = new int[n];
//         int[] right = new int[n];

//         // Fill left max array
//         left[0] = height[0];
//         for (int i = 1; i < n; i++) {
//             left[i] = Math.max(left[i - 1], height[i]);
//         }

//         // Fill right max array
//         right[n - 1] = height[n - 1];
//         for (int i = n - 2; i >= 0; i--) {
//             right[i] = Math.max(right[i + 1], height[i]);
//         }

//         // Calculate trapped water
//         int ans = 0;
//         for (int i = 0; i < n; i++) {
//             ans += Math.min(left[i], right[i]) - height[i];
//         }

//         return ans;
//     }
// }

// Optimized version by using two pointers with O(1) space complexity and O(n) time

class Solution {
    public int trap(int[] height) {
        int n = height.length;
        if (n == 0)
            return 0;

        int left = 0, right = n - 1;
        int leftMax = 0, rightMax = 0;
        int ans = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                // Process left side
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    ans += leftMax - height[left];
                }
                left++;
            } else {
                // Process right side
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    ans += rightMax - height[right];
                }
                right--;
            }
        }

        return ans;
    }
}