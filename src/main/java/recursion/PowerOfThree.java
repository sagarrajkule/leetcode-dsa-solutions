/*
 * LeetCode #326 – Power of Three (Easy)
 *
 * Problem:
 * --------
 * Given an integer n, return true if it is a power of three. Otherwise, return false.
 *
 * A power of three means there exists an integer x such that:
 *      n == 3^x
 *
 * Constraints:
 * -2^31 <= n <= 2^31 - 1
 *
 * Example:
 * --------
 * Input: 27   → Output: true    (3^3 = 27)
 * Input: 0    → Output: false   (no power of 3 gives 0)
 * Input: 9    → Output: true    (3^2 = 9)
 * Input: 45   → Output: false
 *
 * Approach:
 * ---------
 * - Handle base case: if n == 1, return true (as 3^0 = 1).
 * - If n is not divisible by 3 or is 0, it's not a power of 3.
 * - Otherwise, recursively check by dividing n by 3.
 *
 * Time Complexity: O(log₃n)
 * Space Complexity: O(log₃n) due to recursion stack
 */

package recursion;

class PowerOfThree {
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

    /**
     * Main method to test via command line.
     * This main method is for testing/debugging locally from the command line.
     * It can be ignored or removed for LeetCode submission.
     * Usage: java recursion.PowerOfThree <number>
     */
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please provide an integer. Example: java recursion.PowerOfThree 27");
            return;
        }

        try {
            int n = Integer.parseInt(args[0]);
            PowerOfThree obj = new PowerOfThree();
            boolean result = obj.isPowerOfThree(n);
            System.out.println("Is " + n + " a power of 3? → " + result);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid integer.");
        }
    }
}
