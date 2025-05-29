class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int sum = 0, max = 0;
        int n = weights.length;

        for (int i = 0; i < n; i++) {
            if (weights[i] > max) {
                max = weights[i];
            }
            sum += weights[i];
        }

        int low = max, high = sum;
        int ans = 0;

        while (low <= high) {
            // Suggession: Added optimization in binary search: mid = low + (high - low) / 2 to prevent overflow.
            // int mid = low + (high - low) / 2;
            int mid = (low + high) / 2;
            if (canShip(mid, weights, n, days)) {
                ans = mid;
                high = mid - 1; // Try to find smaller valid capacity
            } else {
                low = mid + 1; // Need more capacity
            }
        }

        return ans;
    }

    private boolean canShip(int capacity, int[] weights, int n, int totalDays) {
        int sum = 0, days = 1;

        for (int i = 0; i < n; i++) {
            if (sum + weights[i] <= capacity) {
                sum += weights[i];
            } else {
                days++;
                sum = weights[i];
            }
        }

        return days <= totalDays;
    }
}