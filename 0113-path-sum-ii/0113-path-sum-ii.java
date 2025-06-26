/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        helper(root, 0, targetSum, new ArrayList<>());
        return ans;
    }

    // Preorder traversal + backtracking
    private void helper(TreeNode node, int currentSum, int targetSum, List<Integer> currentPath) {
        if (node == null) return;

        // Add current node value to path and sum
        currentPath.add(node.val);
        currentSum += node.val;

        // If it's a leaf and the sum matches, add the path to result
        if (node.left == null && node.right == null && currentSum == targetSum) {
            ans.add(new ArrayList<>(currentPath));
        }

        // Recurse on left and right child
        helper(node.left, currentSum, targetSum, currentPath);
        helper(node.right, currentSum, targetSum, currentPath);

        // Backtrack
        currentPath.remove(currentPath.size() - 1);
    }
}