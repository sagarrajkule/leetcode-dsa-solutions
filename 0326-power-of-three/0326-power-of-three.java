class Solution {
    public boolean isPowerOfThree(int n) {
        if (n == 1) {
            return true; // Base case: 3^0 = 1
        }

        // If n is 0 or not divisible by 3, it's not a power of 3
        if (n == 0 || n % 3 != 0) {
            return false;
        }

        // Recursive call: divide by 3 and check the reduced number
        return isPowerOfThree(n / 3);
    }
}