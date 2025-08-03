public class Solution {
    // Main function to find the longest increasing path in the matrix
    public int longestIncreasingPath(int[][] matrix) {
        int r = matrix.length;      // Number of rows
        int c = matrix[0].length;   // Number of columns
        int[][] res = new int[r][c]; // Memoization array to store the longest path from each cell
        int ans = 0;                // Variable to store the overall maximum path length

        // Try DFS from every cell in the matrix
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                // Compute the longest increasing path from (i, j)
                ans = Math.max(ans, DFS(matrix, res, i, j, r, c));
            }
        }
        return ans; // Return the maximum path length found
    }

    // Helper function: DFS with memoization
    // Returns the longest increasing path starting from cell (i, j)
    private int DFS(int[][] matrix, int[][] res, int i, int j, int r, int c) {
        // If we've already found the answer for this cell, return it
        if (res[i][j] != 0) return res[i][j];

        int val = matrix[i][j]; // Current cell value
        int maxLen = 1;         // At minimum, the path includes this cell

        // Explore all four directions: up, down, left, right

        // Up
        if (i > 0 && matrix[i-1][j] > val) {
            maxLen = Math.max(maxLen, 1 + DFS(matrix, res, i-1, j, r, c));
        }
        // Down
        if (i < r-1 && matrix[i+1][j] > val) {
            maxLen = Math.max(maxLen, 1 + DFS(matrix, res, i+1, j, r, c));
        }
        // Left
        if (j > 0 && matrix[i][j-1] > val) {
            maxLen = Math.max(maxLen, 1 + DFS(matrix, res, i, j-1, r, c));
        }
        // Right
        if (j < c-1 && matrix[i][j+1] > val) {
            maxLen = Math.max(maxLen, 1 + DFS(matrix, res, i, j+1, r, c));
        }

        res[i][j] = maxLen; // Memoize the result for this cell
        return maxLen;      // Return the computed longest path from (i, j)
    }
}
