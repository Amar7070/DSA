class Solution {
    class DSU{
        int parent[];
        int rank[];
        int c;
        DSU(int n) {
            parent = new int[n + 1];
            rank = new int[n + 1];
            for(int i = 0; i <= n; i++) parent[i] = i;
            c = n;
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
            if(px == py) return true;
            if(rank[px] < rank[py]) parent[px] = py;
            else if(rank[px] > rank[py]) parent[py] = px;
            else {
                parent[px] = py;
                rank[py]++;
            }
            c--;
            return false;
        }
    }
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        int count = 0;
        DSU alice = new DSU(n);
        DSU bob = new DSU(n);
        for(int e[] : edges) {
            if(e[0] == 3) {
                boolean a = alice.union(e[1], e[2]);
                boolean b = bob.union(e[1], e[2]);
                if(a || b) count++;
            }
        }
        for(int e[] : edges) {
            if(e[0] == 1) {
                boolean a = alice.union(e[1], e[2]);
                if(a) count++;
            }
        }
        for(int e[] : edges) {
            if(e[0] == 2) {
                boolean b = bob.union(e[1], e[2]);
                if(b) count++;
            }
        }
        if(alice.c != 1 || bob.c != 1) return -1;
        return count;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna