class Solution {
    public int fib(int n) {
        if (n == 0) return 0; // Base case: F(0)
        if (n == 1) return 1; // Base case: F(1)

        // DP array to store computed Fibonacci values
        int[] dp = new int[n + 1];
        dp[0] = 0; // F(0)
        dp[1] = 1; // F(1)

        // Bottom-up calculation
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2]; // F(i) = F(i-1) + F(i-2)
        }

        return dp[n];
    }
}
