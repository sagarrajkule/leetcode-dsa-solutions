class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length(); // length of first word
        int n = word2.length(); // length of second word

        // dp[i][j] = min operations to convert word1[0..i-1] to word2[0..j-1]
        int[][] dp = new int[m + 1][n + 1];

        // Base cases: word1 to empty and empty to word2
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i; // delete all i characters
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j; // insert all j characters
        }

        // Fill the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    // Characters match, no operation needed
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // Characters don't match:
                    // Choose the best among insert, delete, or replace

                    // Formula:
                    // dp[i][j] = 1 + min(
                    //    dp[i - 1][j],    // delete from word1
                    //    dp[i][j - 1],    // insert into word1
                    //    dp[i - 1][j - 1] // replace in word1
                    // )

                    dp[i][j] = 1 + Math.min(
                            dp[i - 1][j], // delete
                            Math.min(
                                    dp[i][j - 1], // insert
                                    dp[i - 1][j - 1] // replace
                            ));
                }
            }
        }

        return dp[m][n]; // Final result
    }
}
