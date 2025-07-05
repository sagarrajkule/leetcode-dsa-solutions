class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0; // Total gas we have across all stations
        int currGas = 0; // Current gas in the tank during the simulation
        int startIndex = 0; // Candidate starting index for the journey

        // Traverse all stations
        for (int i = 0; i < gas.length; i++) {
            int diff = gas[i] - cost[i]; // Net gain or loss at station i
            totalGas += diff; // Track total gas balance
            currGas += diff; // Update current tank level

            // If tank goes negative, this start index won't work
            if (currGas < 0) {
                // Start fresh from the next station
                startIndex = i + 1;
                currGas = 0;
            }
        }

        // If totalGas is negative, it's impossible to complete the circuit
        return totalGas >= 0 ? startIndex : -1;
    }
}
