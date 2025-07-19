class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        // dp[i][j] will store the length of the LCS of text1[0..i-1] and text2[0..j-1]
        int[][] dp = new int[n + 1][m + 1];

        // Fill the dp table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                // If current characters match, include it and add 1 to previous diagonal cell
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    // Otherwise, take the max of excluding current char from either string
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // The value at dp[n][m] contains the length of the longest common subsequence
        return dp[n][m];
    }
}
