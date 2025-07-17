class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[] dp = new int[n];

        // Fill the first row
        dp[0] = grid[0][0];
        for (int j = 1; j < n; j++) {
            dp[j] = dp[j - 1] + grid[0][j];
        }

        // Fill rest of the rows
        for (int i = 1; i < m; i++) {
            // Update first column separately (can only come from top)
            dp[0] = dp[0] + grid[i][0];

            for (int j = 1; j < n; j++) {
                // Minimum of coming from top (dp[j]) or left (dp[j - 1])
                dp[j] = Math.min(dp[j], dp[j - 1]) + grid[i][j];
            }
        }

        return dp[n - 1]; // Final cell (bottom-right)
    }
}
