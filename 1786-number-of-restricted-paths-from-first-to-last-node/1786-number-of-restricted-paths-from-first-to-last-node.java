class Pair {
    int v;
    int w;
    Pair (int v, int w) {
        this.v = v;
        this.w = w;
    }
}
class Solution {
    int mod = 1000000007;
    public int countRestrictedPaths(int n, int[][] edges) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int e[] : edges) {
            int u = e[0] - 1;
            int v = e[1] - 1;
            int w = e[2];
            adj.get(u).add(new Pair(v, w));
            adj.get(v).add(new Pair(u, w));
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int dist[] = new int[n];
        Arrays.fill (dist, Integer.MAX_VALUE);
        dist[n - 1] = 0;
        pq.add(new int[] {n - 1, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[0];
            int w = curr[1];

            if (w > dist[u]) continue;

            for (Pair p : adj.get(u)) {
                int v = p.v;
                int wei = p.w;
                if (dist[u] + wei < dist[v]) {
                    dist[v] = dist[u] + wei;
                    pq.add (new int[] {v, dist[v]});
                }
            }
        }
        long dp[] = new long[n];
        Arrays.fill (dp, -1);
        return (int)dfs (0, n, adj, dist, dp);
    }
    private long dfs (int u, int n, List<List<Pair>> adj, int[] dist, long[] dp) {
        if (u == n - 1) return 1;
        if (dp[u] != -1) return dp[u];
        long ans = 0;
        for (Pair p : adj.get(u)) {
            int v = p.v;
            if (dist[u] > dist[v]) {
                ans = (ans + dfs (v, n, adj, dist, dp)) % mod;
            }
        }
        return dp[u] = ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna