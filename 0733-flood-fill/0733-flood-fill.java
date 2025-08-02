class Solution {
    // Main function to perform flood fill on the image
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalColor = image[sr][sc]; // Get the original color at starting pixel
        // If the new color is the same as original, no need to proceed
        if (originalColor == color) return image;

        // Start the DFS fill from the starting coordinates
        dfs(image, sr, sc, originalColor, color);
        return image; // Return the modified image
    }

    // Helper DFS function to fill connected pixels
    private void dfs(int[][] image, int r, int c, int originalColor, int newColor) {
        int rows = image.length, cols = image[0].length;
        // Check boundaries and if pixel's color matches the original color
        if (r < 0 || r >= rows || c < 0 || c >= cols || image[r][c] != originalColor) {
            return;
        }
        // Fill current pixel with the new color
        image[r][c] = newColor;

        // Recursively process all four neighbors (down, up, right, left)
        dfs(image, r + 1, c, originalColor, newColor); // Down
        dfs(image, r - 1, c, originalColor, newColor); // Up
        dfs(image, r, c + 1, originalColor, newColor); // Right
        dfs(image, r, c - 1, originalColor, newColor); // Left
    }
}
