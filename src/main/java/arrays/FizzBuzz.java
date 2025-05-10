/*
 * 412. Fizz Buzz
 * Difficulty: Easy
 *
 * Given an integer n, return a string array answer (1-indexed) where:
 *
 * - answer[i] == "FizzBuzz" if i is divisible by 3 and 5.
 * - answer[i] == "Fizz" if i is divisible by 3.
 * - answer[i] == "Buzz" if i is divisible by 5.
 * - answer[i] == i (as a string) if none of the above conditions are true.
 *
 * Examples:
 *
 * Example 1:
 * Input: n = 3
 * Output: ["1","2","Fizz"]
 *
 * Example 2:
 * Input: n = 5
 * Output: ["1","2","Fizz","4","Buzz"]
 *
 * Example 3:
 * Input: n = 15
 * Output: ["1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"]
 *
 * Constraints:
 * 1 <= n <= 10^4
 *
 * ---------------------------------------------------------------
 * Time Complexity: O(n)
 *  - We iterate from 1 to n once, performing constant-time operations.
 *
 * Space Complexity: O(n)
 *  - We store n strings in the output list.
 */

package arrays;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
    /**
     * Main logic for the FizzBuzz problem.
     * Given an integer n, returns a list of strings from 1 to n
     * with the following rules:
     * - "FizzBuzz" for numbers divisible by 3 and 5,
     * - "Fizz" for numbers divisible by 3,
     * - "Buzz" for numbers divisible by 5,
     * - the number itself as a string otherwise.
     * <p>
     * This method is the only required part for LeetCode submissions.
     */
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0) {
                result.add("FizzBuzz");
            } else if (i % 3 == 0) {
                result.add("Fizz");
            } else if (i % 5 == 0) {
                result.add("Buzz");
            } else {
                result.add(Integer.toString(i));
            }
        }

        return result;
    }

    /**
     * This main method is for testing/debugging locally from the command line.
     * It can be ignored or removed for LeetCode submission.
     * <p>
     * Usage:
     * java arrays.FizzBuzz 15
     */
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please provide a number as an argument. Example: java arrays.FizzBuzz 5");
            return;
        }

        try {
            int n = Integer.parseInt(args[0]);
            FizzBuzz fb = new FizzBuzz();
            List<String> result = fb.fizzBuzz(n);
            result.forEach(System.out::println);
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format. Please provide an integer.");
        }
    }
}
