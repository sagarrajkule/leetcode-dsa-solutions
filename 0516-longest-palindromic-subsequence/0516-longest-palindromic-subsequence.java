class Solution {
    public int longestPalindromeSubseq(String s) {
        String reversed = new StringBuilder(s).reverse().toString();
        int n = s.length();

        // dp[i][j] stores the LCS length of s[0..i-1] and reversed[0..j-1]
        int[][] dp = new int[n + 1][n + 1];

        // Fill dp table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {

                // If characters match, extend the subsequence
                if (s.charAt(i - 1) == reversed.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    // Otherwise, take max from excluding either character
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // Final result is the LCS between s and its reverse => LPS length
        return dp[n][n];
    }
}
