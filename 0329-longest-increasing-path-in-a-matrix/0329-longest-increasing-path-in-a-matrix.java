class Solution {
    private int m, n;
    private int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    public int longestIncreasingPath(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        int maxLen = 0;
        int[][] memo = new int[m][n];  // Cache for memoization
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxLen = Math.max(maxLen, dfs(matrix, i, j, memo));
            }
        }
        return maxLen;
    }
    
    private int dfs(int[][] matrix, int i, int j, int[][] memo) {
        // If already computed longest path from this cell, return that
        if (memo[i][j] != 0) return memo[i][j];
        
        int max = 1;  // The cell itself counts as length 1
        
        // Explore 4 directions
        for (int[] dir : dirs) {
            int x = i + dir[0], y = j + dir[1];
            // Check boundaries and increasing condition
            if (x >= 0 && x < m && y >= 0 && y < n && matrix[x][y] > matrix[i][j]) {
                int len = 1 + dfs(matrix, x, y, memo);
                max = Math.max(max, len);
            }
        }
        
        memo[i][j] = max;  // Memoize and return
        return max;
    }
}
