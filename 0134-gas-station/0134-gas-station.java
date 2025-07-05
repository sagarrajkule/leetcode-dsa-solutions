class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int totalSurplus = 0; // Total net gas over the entire route

        // Step 1: Calculate total net gas (surplus)
        for (int i = 0; i < n; i++) {
            totalSurplus += gas[i] - cost[i];
        }

        // If total gas is less than total cost, it's impossible to complete the circuit
        if (totalSurplus < 0) {
            return -1;
        }

        int currentTank = 0;  // Gas in tank while simulating the journey
        int startIndex = 0;   // Potential starting station index

        // Step 2: Find the correct starting station
        for (int i = 0; i < n; i++) {
            currentTank += gas[i] - cost[i];

            // If gas tank goes negative, can't reach the next station from current start
            if (currentTank < 0) {
                // Reset: try the next station as starting point
                startIndex = i + 1;
                currentTank = 0;
            }
        }

        // If we completed the loop, return the valid starting station
        return startIndex;
    }
}
