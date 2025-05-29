class Solution {
    public int mostBooked(int n, int[][] meetings) {
        long[] arr = new long[n]; // Fixed 'ling' to 'long'
        int[] count = new int[n];

        // Sort meetings by start time
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        for (int i = 0; i < meetings.length; i++) {
            int start = meetings[i][0];
            int end = meetings[i][1];
            boolean flag = false;
            long min = Long.MAX_VALUE;
            int minIndex = -1;

            for (int j = 0; j < n; j++) { // Fixed loop variable and condition
                if (arr[j] < min) {
                    min = arr[j];
                    minIndex = j;
                }
                if (arr[j] <= start && !flag) {
                    arr[j] = end;
                    count[j]++;
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                arr[minIndex] += (end - start);
                count[minIndex]++;
            }
        }

        int maxi = -1;
        int ans = -1;
        for (int i = 0; i < n; i++) {
            if (count[i] > maxi) { // Fixed count(i) to count[i]
                maxi = count[i];
                ans = i;
            }
        }

        return ans;
    }
}
