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
    int sum = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        sum(root); // Call the recursive traversal
        return sum; // Return the accumulated result
    }

    // Preorder helper function
    private void sum(TreeNode node) {
        // Base case: if node is null, return
        if (node == null)
            return;

        // Check if left child exists and is a leaf node
        if (node.left != null && node.left.left == null && node.left.right == null) {
            sum += node.left.val;
        }

        // Traverse left and right subtree
        sum(node.left);
        sum(node.right);
    }
}
