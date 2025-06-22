/*
 * LeetCode Problem: 78. Subsets
 * Link: https://leetcode.com/problems/subsets/
 *
 * Difficulty: Medium
 *
 * Description:
 * Given an integer array `nums` containing **unique** elements, return all possible
 * subsets (also known as the power set).
 *
 * The solution set must not contain duplicate subsets. You may return the subsets in any order.
 *
 * Examples:
 *
 * Example 1:
 * Input: nums = [1, 2, 3]
 * Output: [[], [1], [2], [1, 2], [3], [1, 3], [2, 3], [1, 2, 3]]
 *
 * Example 2:
 * Input: nums = [0]
 * Output: [[], [0]]
 *
 * Constraints:
 * - 1 <= nums.length <= 10
 * - -10 <= nums[i] <= 10
 * - All elements in nums are unique
 *
 * Notes:
 * This problem is commonly solved using:
 *   - Backtracking (recursive)
 *   - Bit manipulation (iterative)
 *
 * In the backtracking approach, we explore two choices at each index:
 *   - Include the current element
 *   - Exclude the current element
 * This ensures that all combinations (2^n) are generated.
 */

package recursion;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    // Generates all subsets of the given array
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Func(nums, 0, new ArrayList<>(), result);
        return result;
    }

    // Recursive helper for generating subsets
    void Func(int[] nums, int start, List<Integer> path, List<List<Integer>> result) {
        result.add(new ArrayList<>(path)); // Add current subset

        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);              // Include current element
            Func(nums, i + 1, path, result); // Recurse
            path.remove(path.size() - 1);    // Backtrack
        }
    }

    /**
     * Main method to test via command line.
     * Usage: java Subsets 1 2 3
     */
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please provide space-separated integers. Example: java Solution 1 2 3");
            return;
        }

        try {
            int[] nums = new int[args.length];
            for (int i = 0; i < args.length; i++) {
                nums[i] = Integer.parseInt(args[i]);
            }

            Subsets obj = new Subsets();
            List<List<Integer>> subsets = obj.subsets(nums);

            System.out.println("All subsets:");
            for (List<Integer> subset : subsets) {
                System.out.println(subset);
            }

        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter only integers.");
        }
    }
}
