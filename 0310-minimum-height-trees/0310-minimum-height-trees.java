class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return Arrays.asList(0);

        List<Integer>[] adj = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        int deg[] = new int[n];

        for (int e[] : edges) {
            int u = e[0];
            int v = e[1];

            adj[u].add(v);
            adj[v].add(u);

            deg[u]++;
            deg[v]++;
        }

        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (deg[i] == 1) q.add(i);
        }
        int rem = n;

        while (rem > 2) {
            int size = q.size();
            rem -= size;
            while (size-- > 0) {
                int u = q.poll();

                for (int v : adj[u]) {
                    deg[v]--;

                    if (deg[v] == 1) q.add(v);
                }
            }
        }
        return new ArrayList<>(q);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna