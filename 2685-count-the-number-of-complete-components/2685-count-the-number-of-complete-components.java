class Solution {
    class DSU {
        int parent[];
        int rank[];
        DSU (int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        int find (int x) {
            return parent[x] == x ? x : (parent[x] = find(parent[x]));
        }

        void union (int x, int y) {
            int px = find(x);
            int py = find(y);
            if (px == py) return;
            if (rank[px] < rank[py]) parent[px] = py;
            else if (rank[px] > rank[py]) parent[py] = px;
            else {
                parent[px] = py;
                rank[py]++;
            }
        }
    }
    public int countCompleteComponents(int n, int[][] edges) {
        DSU dsu = new DSU(n);
        for (int e[] : edges) {
            dsu.union(e[0], e[1]);
        }
        int count[] = new int[n];
        int size[] = new int[n];
        for (int i = 0; i < n; i++) {
            size[dsu.find(i)]++;
        }
        for (int e[] : edges) {
            count[dsu.find(e[0])]++;
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (dsu.find(i) == i) {
                if (count[i] == size[i] * (size[i] - 1) / 2) ans++;
            }
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna