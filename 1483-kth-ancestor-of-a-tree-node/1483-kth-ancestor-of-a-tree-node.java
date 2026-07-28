class TreeAncestor {
    int[][] up;
    int log;
    public TreeAncestor(int n, int[] parent) {
        log = (int) (Math.log(n) / Math.log(2)) + 1;
        up = new int[n][log];

        for (int i = 0; i < n; i++) Arrays.fill (up[i], -1);

        for (int v = 0; v < n; v ++) {
            up[v][0] = parent[v];
        }

        for (int i = 1; i < log; i++) {
            for (int v = 0; v < n; v++) {
                int prev = up[v][i - 1];
                if (prev != -1) {
                    up[v][i] = up[prev][i - 1];
                }
            }
        }
    }
    
    public int getKthAncestor(int node, int k) {
        for (int i = 0; i < log && node != -1; i++) {
            if ((k & (1 << i)) != 0) {
                node = up[node][i];

                if (node == -1) {
                    return -1;
                }
            }
        }
        return node;
    }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna