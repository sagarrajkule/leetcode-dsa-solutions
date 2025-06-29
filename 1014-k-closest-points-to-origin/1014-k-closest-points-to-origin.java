import java.util.PriorityQueue;

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // Max-heap based on distance from origin (store [distance, index])
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        for (int i = 0; i < points.length; i++) {
            int dist = distance(points[i]); // compute squared distance
            int[] entry = new int[] { dist, i }; // store distance and index
            pq.add(entry); // add to max-heap

            if (pq.size() > k) {
                pq.poll(); // remove the farthest point
            }
        }

        // Extract k closest points using the stored indices
        int[][] result = new int[k][2];
        int i = 0;
        while (!pq.isEmpty()) {
            int idx = pq.poll()[1]; // get the original point index
            result[i++] = points[idx];
        }

        return result;
    }

    // Helper method to calculate squared distance from origin
    private int distance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}
