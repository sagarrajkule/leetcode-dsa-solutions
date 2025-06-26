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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root, 0, targetSum); 
    }

    // Preorder DFS: root → left → right
    private boolean dfs(TreeNode node, int currentSum, int targetSum) {
        if (node == null) return false;

        currentSum += node.val;

        // If it's a leaf, check if the path sum equals targetSum
        if (node.left == null && node.right == null) {
            return currentSum == targetSum;
        }

        // Check left and right subtrees
        return dfs(node.left, currentSum, targetSum) || dfs(node.right, currentSum, targetSum);
    }
}