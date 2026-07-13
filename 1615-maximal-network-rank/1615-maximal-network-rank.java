class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        int indeg[] = new int[n];
        HashSet<String> set = new HashSet<>();
        int ans = 0;
        for (int r[] : roads) {
            int u = r[0];
            int v = r[1];
            set.add(u + " " + v);
            set.add(v + " " + u);
            indeg[u]++;
            indeg[v]++;
        }
        for (int i = 0; i < n; i++) {
            for (int j =  i + 1; j < n; j++) {
                int curr = indeg[i] + indeg[j];
                if (set.contains(i + " " + j)) curr--;
                ans = Math.max(ans, curr);
            } 
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna