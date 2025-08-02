import java.util.*;

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        dfs(rooms, 0, visited);

        // Check if all rooms are visited
        for (boolean roomVisited : visited) {
            if (!roomVisited) {
                return false;
            }
        }
        return true;
    }

    private void dfs(List<List<Integer>> rooms, int room, boolean[] visited) {
        if (visited[room]) {
            return; // Already visited this room
        }
        visited[room] = true;
        // Explore all keys in current room
        for (int key : rooms.get(room)) {
            dfs(rooms, key, visited);
        }
    }
}
