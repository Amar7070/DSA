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
    Map<Integer, Integer> preMap;
    Map<Integer, Integer> postMap;
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int n = preorder.length;

        preMap = new HashMap<>();
        postMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            preMap.put (preorder[i], i);
            postMap.put (postorder[i], i);
        }

        return solve (0, n - 1, preorder, postorder);
    }

    private TreeNode solve (int start, int end, int[] preorder, int[] postorder) {
        if (start > end) return null;

        TreeNode root = new TreeNode (preorder[start]);
        if (start == end) return root;

        int m = preMap.get(postorder[postMap.get(preorder[start]) - 1]);

        root.left = solve (start + 1, m - 1, preorder, postorder);
        root.right = solve (m, end, preorder, postorder);

        return root;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna