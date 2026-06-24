class Solution {
    class DSU {
        int parent[];
        int  rank[];
        DSU(int n) {
            parent = new int[n];
            rank = new int[n];
            for(int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }
        int find(int x) {
            if(parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
        void union(int x, int y) {
            int px = find(x);
            int py = find(y);
            if(px == py) return;
            if(rank[px] < rank[py]) {
                parent[px] = py;
            }
            else if(rank[px] > rank[py]) {
                parent[py] = px;
            }
            else {
                parent[px] = py;
                rank[py]++;
            }
        }
        int provinces(int n) {
            HashSet<Integer> set = new HashSet<>();
            for(int i = 0; i < n ; i++) {
                set.add(find(i));
            }
            return set.size();
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        DSU dsu = new DSU(n);
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(isConnected[i][j] == 1) {
                    dsu.union(i, j);
                }
            }
        }
        return dsu.provinces(n);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna