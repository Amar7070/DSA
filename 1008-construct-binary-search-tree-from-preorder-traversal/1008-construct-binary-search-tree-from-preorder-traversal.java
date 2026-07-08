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
    private TreeNode constructBST (int start, int end, int[] preorder) {
        if (start > end) return null;

        TreeNode root = new TreeNode(preorder[start]);
        int pivot = end + 1;
        for (int i = start + 1; i <= end; i++) {
            if (preorder[i] > preorder[start]) {
                pivot = i;
                break;
            }
        }
        root.left = constructBST (start + 1, pivot - 1, preorder);
        root.right = constructBST (pivot, end, preorder);

        return root;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        return constructBST(0, preorder.length - 1, preorder);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna