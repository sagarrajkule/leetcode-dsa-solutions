/*
 *  LeetCode #509 – Fibonacci Number   (Easy)
 *  -----------------------------------------------------------
 *  Statement
 *  ---------
 *  The Fibonacci numbers form a sequence in which each number
 *  is the sum of the two preceding ones, starting from 0 and 1:
 *
 *      F(0) = 0,  F(1) = 1
 *      F(n) = F(n – 1) + F(n – 2)  for n > 1
 *
 *  Given an integer n (0 ≤ n ≤ 30), return F(n).
 *
 *  -----------------------------------------------------------
 *  Examples
 *  ---------
 *    n = 2  ➞ 1      //  F(2) = F(1) + F(0) = 1 + 0
 *    n = 3  ➞ 2      //  F(3) = F(2) + F(1) = 1 + 1
 *    n = 4  ➞ 3      //  F(4) = F(3) + F(2) = 2 + 1
 *
 *  -----------------------------------------------------------
 *  Approach (Iterative DP — O(n) time, O(1) space)
 *  -----------------------------------------------------------
 *  1. Handle the base cases n = 0 and n = 1 directly.
 *  2. Starting from i = 2, iteratively compute the next Fibonacci
 *     number as the sum of the previous two, carrying only two*     integers (prev, curr) instead of an entire array.
 *
 *  This avoids recursion-overhead and memoization-storage while
 *  remaining linear in time. Because n ≤ 30, overflow is not an
 *  issue with 32-bit ints.
 *
 *  -----------------------------------------------------------
 *  Complexity
 *  ----------
 *  • Time : O(n)    (one loop from 2 to n)
 *  • Space : O(1)   (only two variables kept)
 *
 *  -----------------------------------------------------------
 *  Reference
 *  ---------
 *  https://leetcode.com/problems/fibonacci-number/
 */

package recursion;

class FibonacciNumber {
    public int fib(int n) {
        if (n < 2) return n;        // Base cases: F(0) = 0, F(1) = 1

        int prev = 0, curr = 1;     // Initial values: F(0), F(1)

        for (int i = 2; i <= n; i++) {
            int next = prev + curr; // Compute F(i) = F(i-1) + F(i-2)
            prev = curr;            // Move forward
            curr = next;
        }

        return curr;                // F(n)
    }

    /**
     * This main method is for testing/debugging locally from the command line.
     * It can be ignored or removed for LeetCode submission.
     * <p>
     * Usage:
     * java FibonacciNumber 5
     */
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please provide a number as an argument. Example: java FibonacciNumber 5");
            return;
        }

        try {
            int n = Integer.parseInt(args[0]);
            FibonacciNumber fn = new FibonacciNumber();
            int result = fn.fib(n);
            System.out.println(result);
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format. Please provide an integer.");
        }
    }
}
