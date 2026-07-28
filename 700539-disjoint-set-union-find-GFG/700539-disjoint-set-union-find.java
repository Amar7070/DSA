class DSU {
    int parent[];
    int rank[];
    DSU (int n) {
        parent = new int[n + 1];
        rank = new int[n + 1];
        for (int i = 0; i <= n; i++) parent[i] = i;
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
        
        parent[px] = py;
        rank[py]++;
    }
}
class Solution {
    public ArrayList<Integer> DSU(int n, int[][] queries) {
        ArrayList<Integer> ans = new ArrayList<>();
        DSU dsu = new DSU(n);
        for (int q[] : queries) {
            int type = q[0];
            if (type == 1) {
                int u = q[1];
                int v = q[2];
                dsu.union(u, v);
            }
            else {
                int x = q[1];
                ans.add(dsu.find(x));
            }
        }
        return ans;
        
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna