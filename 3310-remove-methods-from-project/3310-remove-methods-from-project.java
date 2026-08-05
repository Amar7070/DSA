class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<Integer> ans = new ArrayList<>();
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int e[] : invocations) {
            int u = e[0];
            int v = e[1];
            adj.get(u).add(v);
        }
        boolean visited[] = new boolean[n];
        Queue<Integer> q = new ArrayDeque<>();
        q.add(k);
        visited[k] = true;

        while(!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int u = q.poll();

                for (int v : adj.get(u)) {
                    if (!visited[v]) {
                        q.add(v);
                        visited[v] = true;
                    }
                }
            }
        }

        for (int e[] : invocations) {
            int u = e[0];
            int v = e[1];
            if (!visited[u] && visited[v]) {
                for (int i = 0; i < n; i++) {
                    ans.add(i);
                }
                return ans;
            }
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) ans.add(i);
        }

        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna