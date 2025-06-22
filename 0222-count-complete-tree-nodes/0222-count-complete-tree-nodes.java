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
    public int countNodes(TreeNode root) {
        // Base case: if node is null, just return
        if (root == null)
            return 0;

        int leftHeight = getLeftHeight(root);
        int rightHeight = getRightHeight(root);

        // If it's a perfect binary tree
        if (leftHeight == rightHeight) {
            return (1 << leftHeight) - 1; // 2^h - 1
        }

        // Otherwise, recursively count nodes
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    // Get height by going left
    private int getLeftHeight(TreeNode node) {
        int height = 0;
        while (node != null) {
            height++;
            node = node.left;
        }
        return height;
    }

    // Get height by going right
    private int getRightHeight(TreeNode node) {
        int height = 0;
        while (node != null) {
            height++;
            node = node.right;
        }
        return height;
    }
}
