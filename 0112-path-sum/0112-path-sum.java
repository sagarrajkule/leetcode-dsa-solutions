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
    private boolean ans = false;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        dfs(root, 0, targetSum);
        return ans;
    }

    // Preorder DFS: root → left → right
    private void dfs(TreeNode node, int currentSum, int targetSum) {
        if (node == null)
            return;

        currentSum += node.val;

        // If leaf node, check if path sum equals target
        if (node.left == null && node.right == null) {
            if (currentSum == targetSum) {
                ans = true;
            }
            return;
        }

        dfs(node.left, currentSum, targetSum);
        dfs(node.right, currentSum, targetSum);
    }
}