class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        // dp[i][j] stores the length of LCS between word1[0..i-1] and word2[0..j-1]
        int[][] dp = new int[m + 1][n + 1];

        // Build the dp table using Bottom-Up Dynamic Programming
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // If current characters match, extend the LCS by 1
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    // Else, choose the maximum LCS by ignoring one character from either string
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        int lcs = dp[m][n];

        // Formula: Minimum deletions = (len1 - LCS) + (len2 - LCS)
        // Because only deletions are allowed, we delete all non-LCS characters from both strings
        return (m - lcs) + (n - lcs);
    }
}
