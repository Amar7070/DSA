class Solution {
    class DSU {
        int parent[];
        int rank[];
        int count;
        DSU (int n) {
            parent = new int[n];
            rank = new int[n];
            for (int  i = 0 ; i < n; i++) parent[i] = i;
            count = n;
        }
        int find (int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        boolean union (int x, int y) {
            int px = find(x);
            int py = find(y);
            if (px == py) return true;
            if (rank[px] > rank[py]) {
                parent[py] = px;
            }
            else if (rank[px] < rank[py]) {
                parent[px] = py;
            }
            else {
                parent[px] = py;
                rank[py]++;
            }
            count--;
            return false;
        }
    }
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        DSU dsu = new DSU(n);
        int indegree[] = new int[n];
        for (int i = 0; i < n; i++) {
            if (leftChild[i] != -1) {
                if(++indegree[leftChild[i]] > 1) return false;
                if(dsu.union(i, leftChild[i])) return false;
            }
        }
        for (int i = 0; i < n; i++) {
            if (rightChild[i] != -1) {
                if(++indegree[rightChild[i]] > 1) return false;
                if(dsu.union(i, rightChild[i])) return false;
            }
        }
        int roots = 0;
        for (int x : indegree) {
            if (x == 0) roots++;
        }
        return dsu.count == 1 && roots == 1;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna