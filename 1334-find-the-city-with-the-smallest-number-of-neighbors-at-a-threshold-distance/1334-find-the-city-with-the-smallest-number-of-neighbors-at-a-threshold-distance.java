class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int dist[][] = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n ; j++) {
                if(i == j) continue;
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        for(int e[] : edges) {
            int u = e[0];
            int v = e[1];
            int w = e[2];
            dist[u][v] = w;
            dist[v][u] = w;
        }
        for(int k = 0; k < n; k++) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }
        int maxVis = n;
        int ans = -1;
        for(int i = 0; i < n; i++) {
            int count = 0;
            for(int j = 0; j < n; j++) {
                if(dist[i][j] <= distanceThreshold) count++;
            }
            if(count <= maxVis) {
                maxVis = count;
                ans = i;
            }
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna