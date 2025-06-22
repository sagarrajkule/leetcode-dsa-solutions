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

class Solution {

    // Main method to generate all subsets of the given array
    public List<List<Integer>> subsets(int[] nums) {
        // This will store all the subsets (the power set)
        List<List<Integer>> result = new ArrayList<>();

        // Start the recursive backtracking function
        Func(nums, 0, new ArrayList<>(), result);

        return result;
    }

    /*
     * Recursive helper function to build subsets
     * @param nums: input array of unique integers
     * @param start: current index to consider
     * @param path: current subset being constructed
     * @param result: final list to store all subsets
     */
    void Func(int[] nums, int start, List<Integer> path, List<List<Integer>> result) {
        // Add the current subset (path) to the result
        result.add(new ArrayList<>(path));

        // Iterate through the array elements starting from index 'start'
        for (int i = start; i < nums.length; i++) {
            // Include nums[i] in the current subset
            path.add(nums[i]);

            // Recurse to build further subsets including nums[i]
            Func(nums, i + 1, path, result);

            // Backtrack: remove the last added element to explore other subsets
            path.remove(path.size() - 1);
        }
    }
}
