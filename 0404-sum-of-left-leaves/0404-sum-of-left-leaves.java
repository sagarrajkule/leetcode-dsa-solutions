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

    // Preorder helper function. Preorder traversal visits nodes in this order: root → left → right
    private void sum(TreeNode root) {
        // Base case: if root is null, return
        if (root == null)
            return;

        // Check if left child exists and is a leaf node
        if (root.left != null && root.left.left == null && root.left.right == null) {
            sum += root.left.val;
        }

        // Traverse left and right subtree
        sum(root.left);
        sum(root.right);
    }
}
