class Solution {
    private boolean dfs (int u, List<List<Integer>> adj, int[] state) {
        state[u] = 1;

        for (int v : adj.get(u)) {
            if (state[v] == 1) return false;

            if (state[v] == 0) {
                if (!dfs (v, adj, state)) return false;
            }
        }

        state[u] = 2;
        return true;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());

        for (int p[] : prerequisites) {
            int u = p[0];
            int v = p[1];
            adj.get(u).add(v);
        }
        int state[] = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (state[i] == 0) {
                if (!dfs (i, adj, state)) return false;
            }
        }

        return true;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna