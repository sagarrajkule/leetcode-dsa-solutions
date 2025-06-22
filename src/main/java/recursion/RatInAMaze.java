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

package recursion;

import java.util.*;

public class RatInAMaze {
    // Function to find all possible paths
    public ArrayList<String> ratInMaze(int[][] maze) {
        ArrayList<String> ans = new ArrayList<>();
        int n = maze.length;

        if (maze[0][0] == 0 || maze[n - 1][n - 1] == 0) return ans;

        boolean[][] visited = new boolean[n][n];
        backtrack(maze, 0, 0, "", visited, ans);
        Collections.sort(ans);
        return ans;
    }

    // DFS helper
    private void backtrack(int[][] maze, int row, int col, String path, boolean[][] visited, ArrayList<String> result) {
        int n = maze.length;

        if (row == n - 1 && col == n - 1) {
            result.add(path);
            return;
        }

        if (row < 0 || col < 0 || row >= n || col >= n || visited[row][col] || maze[row][col] == 0) return;

        visited[row][col] = true;

        backtrack(maze, row + 1, col, path + 'D', visited, result);
        backtrack(maze, row, col - 1, path + 'L', visited, result);
        backtrack(maze, row, col + 1, path + 'R', visited, result);
        backtrack(maze, row - 1, col, path + 'U', visited, result);

        visited[row][col] = false;
    }

    /**
     * Main method to test via console input.
     * Usage: run and enter size followed by matrix rows.
     * Example:
     * Enter the size of the maze (n x n): 4
     * Enter the maze row by row (0 for block, 1 for open path):
     * 1 0 0 0
     * 1 1 0 1
     * 1 1 0 0
     * 0 1 1 1
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read matrix size
        System.out.print("Enter the size of the maze (n x n): ");
        int n = scanner.nextInt();
        int[][] maze = new int[n][n];

        // Read the maze matrix
        System.out.println("Enter the maze row by row (0 for block, 1 for open path):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                maze[i][j] = scanner.nextInt();
            }
        }

        RatInAMaze obj = new RatInAMaze();
        ArrayList<String> paths = obj.ratInMaze(maze);

        if (paths.isEmpty()) {
            System.out.println("No path exists.");
        } else {
            System.out.println("Possible paths:");
            for (String path : paths) {
                System.out.println(path);
            }
        }

        scanner.close();
    }
}
