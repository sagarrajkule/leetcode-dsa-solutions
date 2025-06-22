
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
    // List to store the result of inorder traversal
    List<Integer> ans = new ArrayList<>();

    // Public method to initiate inorder traversal
    public List<Integer> inorderTraversal(TreeNode root) {
        inorder(root); // Start traversal from root
        return ans; // Return the result list
    }

    // Helper method for recursive inorder traversal
    private void inorder(TreeNode root) {
        // Base case: if node is null, just return
        if (root == null) {
            return;
        }

        // Step 1: Traverse the left subtree
        inorder(root.left);

        // Step 2: Visit the current node
        ans.add(root.val);

        // Step 3: Traverse the right subtree
        inorder(root.right);
    }
}