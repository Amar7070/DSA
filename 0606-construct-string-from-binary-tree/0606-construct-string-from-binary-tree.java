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
    public String tree2str(TreeNode root) {
        if (root == null) return  "";

        String ans = String.valueOf(root.val); 
        String left = tree2str(root.left);
        String right = tree2str(root.right);

        if (root.left == null && root.right == null) {
            return ans;
        }

        if (root.left == null) {
            return ans + "()" + "(" + right + ")";
        }

        if (root.right == null) {
            return ans + "(" + left + ")";
        }

        return ans + "(" + left + ")" + "(" + right + ")";
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna