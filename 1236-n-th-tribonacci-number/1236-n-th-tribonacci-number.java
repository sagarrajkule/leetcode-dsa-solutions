class Solution {
    public int tribonacci(int n) {
        // Base cases
        if (n == 0) return 0;        // T0 = 0
        if (n == 1 || n == 2) return 1; // T1 = 1, T2 = 1

        // Initialize the first three Tribonacci numbers
        int t0 = 0; // T0
        int t1 = 1; // T1
        int t2 = 1; // T2

        // Compute from T3 to Tn iteratively
        for (int i = 3; i <= n; i++) {
            int t3 = t0 + t1 + t2; // Tn = Tn-1 + Tn-2 + Tn-3
            // Shift values for next iteration
            t0 = t1;
            t1 = t2;
            t2 = t3;
        }

        // Final value is stored in t2 after loop
        return t2;
    }
}
