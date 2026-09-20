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
        StringBuilder sb = new StringBuilder();

        solve (root, sb);

        return sb.toString();
    }

    private void solve (TreeNode root, StringBuilder sb) {
        if (root == null) return;

        sb.append(root.val);

        if(root.left != null || root.right != null) {
            sb.append("(");
            solve (root.left, sb);
            sb.append(")");
        }

        if (root.right != null) {
            sb.append("(");
            solve (root.right, sb);
            sb.append(")");
        }
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna