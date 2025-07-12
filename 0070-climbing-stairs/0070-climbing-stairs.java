class Solution {
    public int climbStairs(int n) {
        if (n <= 2) return n; // Base cases

        int[] dp = new int[n + 1];
        dp[1] = 1; // One way to climb 1 stair
        dp[2] = 2; // Two ways to climb 2 stairs

        // Bottom-up DP: ways to reach each step
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2]; // Previous 1-step + 2-step ways
        }

        return dp[n];
    }
}
