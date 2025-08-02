class Solution {
    // Direction vectors for moving up, down, left, and right
    private static final int[][] DIRECTIONS = {{0,1},{1,0},{0,-1},{-1,0}};
    private int rows, cols;

    // Main function to compute the longest increasing path in the matrix
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;

        rows = matrix.length;
        cols = matrix[0].length;
        int maxPath = 0;

        // Memoization array to store the longest path from each cell
        int[][] memo = new int[rows][cols];

        // Try to find the longest path starting from every cell
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                maxPath = Math.max(maxPath, dfs(matrix, i, j, memo));
            }
        }
        return maxPath;
    }

    // DFS function to compute length of increasing path from (row, col)
    private int dfs(int[][] matrix, int row, int col, int[][] memo) {
        // If answer already computed for this cell, reuse it
        if (memo[row][col] != 0) return memo[row][col];

        int maxLen = 1; // At least the cell itself is a path of length 1

        for (int[] dir : DIRECTIONS) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            // Check boundaries and increasing condition
            if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols
                    && matrix[newRow][newCol] > matrix[row][col]) {

                // Recursively find the longest path from the adjacent cell
                int len = 1 + dfs(matrix, newRow, newCol, memo);

                // Update the maximum length found so far
                maxLen = Math.max(maxLen, len);
            }
        }
        // Memoize the result for the current cell
        memo[row][col] = maxLen;
        return maxLen;
    }
}
