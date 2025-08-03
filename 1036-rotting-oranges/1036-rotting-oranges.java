import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;           // Number of rows in grid
        int cols = grid[0].length;        // Number of columns in grid
        int freshCount = 0;               // Count of fresh oranges
        int rottenCount = 0;              // Count of rotten oranges (optional tracking)

        Queue<int[]> rottenQueue = new LinkedList<>();  // Queue for BFS holding positions of rotten oranges

        // Traverse the grid to initialize counts and enqueue rotten oranges
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    rottenCount++;
                    rottenQueue.offer(new int[]{i, j});
                }
                if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }

        // If there are no fresh oranges, no time needed to rot anything
        if (freshCount == 0) {
            return 0;
        }

        // Directions: down, right, up, left (to explore neighbors)
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        int minutes = 0;  // Time elapsed in minutes

        // Start BFS from initially rotten oranges and rot adjacent fresh ones level-by-level
        while (!rottenQueue.isEmpty()) {
            int size = rottenQueue.size(); // Number of rotten oranges to process this minute

            for (int i = 0; i < size; i++) {
                int[] current = rottenQueue.poll();   // Dequeue the next rotten orange position
                int x = current[0];
                int y = current[1];

                // Explore all four adjacent positions
                for (int j = 0; j < 4; j++) {
                    int newX = x + dx[j];
                    int newY = y + dy[j];

                    // Check boundaries and whether fresh orange is present
                    if (newX >= 0 && newX < rows && newY >= 0 && newY < cols 
                            && grid[newX][newY] == 1) {
                        grid[newX][newY] = 2;               // Rot the fresh orange
                        rottenQueue.offer(new int[]{newX, newY}); // Add new rotten orange to the queue
                        freshCount--;                        // Decrement fresh orange count
                    }
                }
            }

            // Increment minutes only if there are new rotten oranges to process
            if (!rottenQueue.isEmpty()) {
                minutes++;
            }
        }

        // If all fresh oranges have been rotten, return time elapsed, else -1
        return freshCount == 0 ? minutes : -1;
    }
}
