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
    int res = 0;
    public int[] solve(TreeNode root) {
        if(root == null) return new int[]{0,0};
        int[] left = solve(root.left);
        int[] right = solve(root.right);
        int sum = root.val + left[0] + right[0];
        int c = 1 + left[1] + right[1];
        if(root.val == (sum/c)) res++;
        return new int[]{sum, c};
    }
    public int averageOfSubtree(TreeNode root) {
        solve(root);
        return res;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna