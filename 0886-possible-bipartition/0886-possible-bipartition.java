class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int d[] : dislikes) {
            int u = d[0] - 1;
            int v = d[1] - 1;
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int color[] = new int[n];
        for (int i = 0; i < n; i++) {
            if (color[i] != 0) continue;
            Queue<Integer> q = new ArrayDeque<>();
            q.add(i);
            color[i] = -1;
            while (!q.isEmpty()) {
                int u = q.poll();
                for (int v : adj.get(u)) {
                    if (color[v] == 0) {
                        q.add(v);
                        color[v] = - color[u];
                    }
                    else if (color[u] == color[v]) return false;
                }
            } 
        }
        return true;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna