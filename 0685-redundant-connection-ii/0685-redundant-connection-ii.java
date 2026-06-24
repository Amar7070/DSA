class Solution {
    class DSU {
        int parent[];
        DSU(int n) {
            parent = new int[n + 1];
            for(int i = 1; i <= n; i++) {
                parent[i] = i;
            }
        }
        int find(int x) {
            if(parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
        boolean union(int x, int y) {
            int px = find(x);
            int py = find(y);
            if(px == py) return false;
            parent[py] = px;
            return true;
        }
    }
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1];
        int[] e1 = null;
        int[] e2 = null;
        for(int[] e : edges) {
            int u = e[0];
            int v = e[1];
            if(parent[v] == 0) {
                parent[v] = u;
            }
            else {
                e1 = new int[]{parent[v], v};
                e2 = new int[]{u,v};

                e[1] = 0;   // Mark second edge invalid temporarily
            }
        }
        DSU dsu = new DSU(n);
        for(int e[] : edges) {
            int u = e[0];
            int v = e[1];
            if(v == 0) continue;
            if(!dsu.union(u, v)) {
                if(e1 == null) {
                    return e;
                }

                return e1;
            }
        }
        return e2;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna