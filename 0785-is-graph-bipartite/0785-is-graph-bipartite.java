class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int color[] = new int[n];
        for(int i = 0; i < n; i++) {
            if(color[i] != 0) continue;
            Queue<Integer> q = new ArrayDeque<>();
            q.add(i);
            color[i] = -1;
            while(!q.isEmpty()) {
                int u = q.poll();
                for(int v : graph[u]) {
                    if(color[v] == color[u]) return false;
                    else if(color[v] == 0) {
                        q.add(v);
                        color[v] = -color[u];
                    }
                }
            }
        }
        return true;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna