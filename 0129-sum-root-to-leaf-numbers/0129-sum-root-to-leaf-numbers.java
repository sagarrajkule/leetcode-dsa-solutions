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
    private int totalSum = 0;

    public int sumNumbers(TreeNode root) {
        dfs(root, 0); // Start DFS with initial value 0
        return totalSum;
    }

    // Preorder DFS to accumulate path values from root to leaf
    // Preorder DFS: root → left → right
    private void dfs(TreeNode node, int currentNumber) {
        if (node == null)
            return;

        // Build the number as we go down
        currentNumber = currentNumber * 10 + node.val;

        // If it's a leaf, add the number to the total sum
        if (node.left == null && node.right == null) {
            totalSum += currentNumber;
            return;
        }

        // Recurse left and right
        dfs(node.left, currentNumber);
        dfs(node.right, currentNumber);
    }
}