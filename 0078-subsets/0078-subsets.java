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
