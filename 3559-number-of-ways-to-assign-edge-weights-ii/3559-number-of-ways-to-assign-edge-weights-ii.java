class Solution {
    int mod = 1000000007;
    int depth[];
    int up[][];
    int log = 0;
    public int[] assignEdgeWeights(int[][] edges, int[][] queries) {
        int n = edges.length + 1;
        List<List<Integer>> adj = new ArrayList<>();
        depth = new int[n + 1];
        while ((1 << log) <= n) log++;
        up = new int[n + 1][log + 1];
        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());
        for (int e[] : edges) {
            int u = e[0];
            int v = e[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        dfs (1, -1, adj);

        int q = queries.length;
        int ans[] = new int[q];
        for (int i = 0; i < q; i++) {
            int u = queries[i][0];
            int v = queries[i][1];
            if (u == v) ans[i] = 0;
            else {
                int l = lca (u, v);
                int d = depth[u] + depth[v] - 2 * depth[l];
                ans[i] = (int) pow (2, d - 1);
            }
        }
        return ans;
    }

    private long pow(long base, int exp) {
        long res = 1;
        while (exp > 0) {
            if (exp % 2 > 0)
                res = res * base % mod;
            base = base * base % mod;
            exp /= 2;
        }
        return res;
    }

    private void dfs (int node, int parent, List<List<Integer>> adj) {
        up[node][0] = parent;

        for (int j = 1; j <= log; j++) {
            if (up[node][j - 1] == -1) {
                up[node][j] = -1;
            }
            else {
                up[node][j] = up[up[node][j - 1]][j - 1];
            }
        }

        for (int child : adj.get(node)) {
            if (child == parent) continue;

            depth[child] = depth[node] + 1;

            dfs (child, node, adj);
        }
    }

    private int kthAncestor (int node, int k) {
        for (int j = 0; j <= log && node != -1; j++) {
            if ((k & (1 << j)) != 0) {
                node = up[node][j];
            }
        }
        return node;
    }

    private int lca (int u, int v) {
        if (depth[u] < depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }

        int diff = depth[u] - depth[v];

        u = kthAncestor(u, diff);

        if (u == v) return u;

        for (int j = log; j >= 0; j--) {
            if (up[u][j] != up[v][j]) {
                u = up[u][j];
                v = up[v][j];
            }
        }

        return up[u][0];
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna