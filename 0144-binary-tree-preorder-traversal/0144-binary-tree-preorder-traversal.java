
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

import java.util.*;

class Solution {
    // List to store the result
    List<Integer> result = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        preorder(root); // Start traversal from root
        return result;
    }

    // Helper method for recursive preorder traversal. Preorder traversal visits nodes in this order: root → left → right
    private void preorder(TreeNode node) {
        // Base case: if node is null, just return
        if (node == null)
            return;

        // Step 1: Visit the root
        result.add(node.val);

        // Step 2: Traverse left subtree
        preorder(node.left);

        // Step 3: Traverse right subtree
        preorder(node.right);
    }
}
