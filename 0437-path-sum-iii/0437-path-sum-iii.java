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
    private int count (TreeNode root, long target) {
        if (root == null) return 0;

        int ans = 0;
        if (root.val == target) ans++;

        ans += count (root.left, target - root.val);
        ans += count (root.right, target - root.val);
        
        return ans;
    }
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;

        return count (root, targetSum) + pathSum (root.left, targetSum) + pathSum (root.right, targetSum); 
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna