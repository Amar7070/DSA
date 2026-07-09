class Solution {
    class DSU {
        int parent[];
        int rank[];
        DSU (int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }
        int find (int x) {
            if (parent[x] != x) {
                parent[x] = find (parent[x]);
            }
            return parent[x];
        }

        void union (int x, int y) {
            int px = find(x);
            int py = find(y);
            if (px == py) return;

            if (rank[px] < rank[py]) parent[px] = py;
            else if (rank[px] > rank[py]) parent[py] = px;
            else {
                parent[px] = py;
                rank[px]++;
            }
        }
    }
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        DSU dsu = new DSU(n);
        for (int i = 1; i < n; i++) {
            if (Math.abs(nums[i] - nums[i - 1]) <= maxDiff) {
                dsu.union(i, i - 1);
            }
        }

        boolean ans[] = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            if (dsu.find(queries[i][0]) == dsu.find(queries[i][1])) ans[i] = true;
        } 
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna