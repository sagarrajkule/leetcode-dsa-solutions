class Solution {
    private int rows, cols;

    // Main method to compute the maximum area of an island in the grid
    public int maxAreaOfIsland(int[][] grid) {
        // Edge case: If grid is empty or null, return 0
        if (grid == null || grid.length == 0)
            return 0;

        rows = grid.length;         // Number of rows in the grid
        cols = grid[0].length;      // Number of columns in the grid
        int maxArea = 0;            // Initialize maximum area to 0

        // Iterate through every cell in the grid
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // If the cell is land (1), explore its island using DFS
                if (grid[i][j] == 1) {
                    // Compute the area for this island and update maxArea if larger
                    maxArea = Math.max(maxArea, dfs(grid, i, j));
                }
            }
        }
        return maxArea;
    }

    // Depth-First Search to visit all land cells connected to (i, j)
    private int dfs(int[][] grid, int i, int j) {
        // Base case: return 0 if out of bounds or cell is water (0)
        if (i < 0 || j < 0 || i >= rows || j >= cols || grid[i][j] == 0)
            return 0;

        // Mark this cell as visited by setting it to water (0)
        grid[i][j] = 0;
        int area = 1; // Current land cell counts as 1

        // Recursively visit all four adjacent cells (up, down, left, right)
        area += dfs(grid, i - 1, j); // Up
        area += dfs(grid, i + 1, j); // Down
        area += dfs(grid, i, j - 1); // Left
        area += dfs(grid, i, j + 1); // Right

        return area; // Total area for this island
    }
}
