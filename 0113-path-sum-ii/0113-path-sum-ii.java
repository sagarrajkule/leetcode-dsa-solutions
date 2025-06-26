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
    private List<List<Integer>> resultPaths = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, 0, targetSum, new ArrayList<>());
        return resultPaths;
    }

    // Preorder DFS + backtracking
    private void dfs(TreeNode node, int currentSum, int targetSum, List<Integer> currentPath) {
        if (node == null) return;

        // Add current node to the path and update sum
        currentPath.add(node.val);
        currentSum += node.val;

        // If it's a leaf and the path sum matches target, store the path
        if (node.left == null && node.right == null && currentSum == targetSum) {
            resultPaths.add(new ArrayList<>(currentPath));
        }

        // Recurse into left and right children
        dfs(node.left, currentSum, targetSum, currentPath);
        dfs(node.right, currentSum, targetSum, currentPath);

        // Backtrack: remove current node before returning
        currentPath.remove(currentPath.size() - 1);
    }
}