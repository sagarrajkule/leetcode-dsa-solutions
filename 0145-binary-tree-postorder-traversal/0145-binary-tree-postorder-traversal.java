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
    // List to store the result
    List<Integer> result = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        postorder(root); // Start traversal from root
        return result;
    }

    // Helper method for recursive postorder traversal. Postorder traversal visits nodes in this order: left → right → root
    private void postorder(TreeNode node) {
        // Base case: if node is null, just return
        if (node == null)
            return;

        // Step 1: Traverse left subtree
        postorder(node.left);

        // Step 2: Traverse right subtree
        postorder(node.right);

        // Step 3: Visit the root
        result.add(node.val);
    }
}