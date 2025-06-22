/*
 * Problem: Rat in a Maze - I
 * Link: https://www.geeksforgeeks.org/problems/rat-in-a-maze-problem/1&selectedLang=python3
 *
 * Description:
 * A rat is placed at position (0, 0) in a square matrix of size n x n.
 * The matrix contains:
 *   - 0: A blocked cell the rat cannot pass through.
 *   - 1: A free cell the rat can move through.
 *
 * The rat's goal is to reach the destination cell at position (n-1, n-1).
 * From any cell, the rat can move in the following four directions:
 *   - 'U' (up), 'D' (down), 'L' (left), 'R' (right)
 *
 * Constraints:
 * - The rat cannot revisit any cell in a single path.
 * - The rat can only move within the matrix bounds.
 * - Return all valid paths in lexicographically sorted order.
 * - If no path exists, return an empty list.
 *
 * Examples:
 *
 * Input:
 * [[1, 0, 0, 0],
 *  [1, 1, 0, 1],
 *  [1, 1, 0, 0],
 *  [0, 1, 1, 1]]
 * Output: ["DDRDRR", "DRDDRR"]
 *
 * Input:
 * [[1, 0],
 *  [1, 0]]
 * Output: []
 *
 * Input:
 * [[1, 1, 1],
 *  [1, 0, 1],
 *  [1, 1, 1]]
 * Output: ["DDRR", "RRDD"]
 *
 * Matrix Size Constraints:
 * 2 ≤ mat.size() ≤ 5
 * 0 ≤ mat[i][j] ≤ 1
 *
 * Note:
 * This implementation uses backtracking and in-place marking of visited cells
 * by temporarily setting them to 0 and restoring after recursive calls.
 */

class Solution {
    // Function to find all possible paths
    public ArrayList<String> ratInMaze(int[][] maze) {
        ArrayList<String> ans = new ArrayList<>();
        int n = maze.length;

        // If the start or end cell is blocked
        if (maze[0][0] == 0 || maze[n - 1][n - 1] == 0) return ans;

        Helper(ans, maze, 0, 0, n, "");
        Collections.sort(ans); // Optional: sort lexicographically
        return ans;
    }

    void Helper(ArrayList<String> ans, int[][] maze, int i, int j, int n, String s) {
        // Base case: reached destination
        if (i == n - 1 && j == n - 1) {
            ans.add(s);
            return;
        }

        // Boundary checks
        if (i < 0 || j < 0 || i >= n || j >= n || maze[i][j] == 0) {
            return;
        }

        // Mark the current cell as visited
        maze[i][j] = 0;

        // Move in all directions
        Helper(ans, maze, i + 1, j, n, s + 'D'); // Down
        Helper(ans, maze, i - 1, j, n, s + 'U'); // Up
        Helper(ans, maze, i, j + 1, n, s + 'R'); // Right
        Helper(ans, maze, i, j - 1, n, s + 'L'); // Left

        // Backtrack
        maze[i][j] = 1;
    }
}
