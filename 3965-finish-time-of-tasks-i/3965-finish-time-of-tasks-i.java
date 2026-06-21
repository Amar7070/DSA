class Solution {
    private long bfs(int node, List<List<Integer>> adj, int[] baseTime) {
        if(adj.get(node).size() == 0) return baseTime[node];
        long ans = 0;
        long max = Long.MIN_VALUE;
        long min = Long.MAX_VALUE;
        for(int v : adj.get(node)) {
            long vn = bfs(v, adj, baseTime);
            max = Math.max(max, vn);
            min = Math.min(min, vn);
        }
        long ownDuration = (max - min) + baseTime[node];
        return max + ownDuration;
    }
    public long finishTime(int n, int[][] edges, int[] baseTime) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for(int e[] : edges) {
            int u = e[0];
            int v = e[1];
            adj.get(u).add(v);
        }
        return bfs(0, adj, baseTime);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna