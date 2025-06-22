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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaf1 = new ArrayList<>();
        List<Integer> leaf2 = new ArrayList<>();

        // Collect leaf nodes for both trees
        dfs(root1, leaf1);
        dfs(root2, leaf2);

        // Compare leaf sequences
        return leaf1.equals(leaf2);
    }

    // DFS (Depth-First Search): Preorder traversal helper to collect leaf nodes
    private void dfs(TreeNode root, List<Integer> leaves) {
        if (root == null)
            return;

        // If leaf node, add value
        if (root.left == null && root.right == null) {
            leaves.add(root.val);
        }

        dfs(root.left, leaves);
        dfs(root.right, leaves);
    }
}
