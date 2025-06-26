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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();

        if (root == null) return paths;

        // Start the recursive traversal from the root
        buildPaths(root, "", paths);

        return paths;
    }

    // Preorder DFS helper method
    private void buildPaths(TreeNode node, String path, List<String> paths) {
        if (node == null) return;

        // Append current node's value to path
        path += Integer.toString(node.val);

        // If it's a leaf, add the path to the result list
        if (node.left == null && node.right == null) {
            paths.add(path);
            return; // ✅ Prevents further "->" appending
        }

        // Continue DFS traversal with arrow separator
        path += "->";
        buildPaths(node.left, path, paths);
        buildPaths(node.right, path, paths);
    }
}