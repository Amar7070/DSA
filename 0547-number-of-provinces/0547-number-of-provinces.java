class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int count = 0;
        boolean visited[] = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs (i, isConnected, visited);
                count++;
            }
        }
        return count;
    }

    private void dfs (int u, int[][] isConnected, boolean[] visited) {
        visited[u] = true;
        for (int i = 0; i < isConnected.length; i++) {
            if (isConnected[u][i] == 1 && !visited[i]) {
                dfs (i, isConnected, visited);
            }
        }
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna