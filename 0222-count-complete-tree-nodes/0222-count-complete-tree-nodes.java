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
    // List to store nodes visited during inorder traversal
    List<Integer> ans = new ArrayList<>();

    public int countNodes(TreeNode root) {
        inorder(root); // Perform inorder traversal
        return ans.size(); // Number of nodes is size of the list
    }

    // Recursive inorder traversal: left → root → right
    private void inorder(TreeNode root) {
        if (root == null) return;

        inorder(root.left);      // Visit left subtree
        ans.add(root.val);       // Visit current node
        inorder(root.right);     // Visit right subtree
    }
}
