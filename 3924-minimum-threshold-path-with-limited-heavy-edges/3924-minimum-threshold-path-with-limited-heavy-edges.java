class Solution {
    private boolean canExist(List<List<int []>> adj, int s, int d, int k, int mid) {
        Deque<Integer> q = new ArrayDeque<>();
        q.addFirst(s);
        int count = 0;
        int dist[] = new int[adj.size()];
        
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[s] = 0;
        while(!q.isEmpty()) {
            int u = q.pollFirst();
            for(int ve[] : adj.get(u)) {
                int v = ve[0];
                int w = ve[1];
                int cost = (w > mid) ? 1 : 0;
                if(dist[u] + cost < dist[v]) {
                    dist[v] = dist[u] + cost;
                    if(cost == 0)
                        q.addFirst(v);
                    else
                        q.addLast(v);
                }
            }
        }
        return dist[d] <= k; 
    }
    public int minimumThreshold(int n, int[][] edges, int source, int target, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        int l = 0;
        int h = 0;
        for(int e[] : edges) {
            int u = e[0];
            int v = e[1];
            int w = e[2];
            adj.get(u).add(new int[] {v, w});
            adj.get(v).add(new int[] {u, w});
            h = Math.max(h, w);
        }
        int ans = -1;
        while(l <= h) {
            int mid = l + (h - l) / 2;
            if(canExist(adj, source, target, k, mid)) {
                ans = mid;
                h = mid - 1;
            }
            else {
                l = mid + 1;
            }
        }
        return ans;
        
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna