class Solution {
    private int[] bfs (int start, List<List<Integer>> adj) {
        Queue<Integer> q = new ArrayDeque<>();
        boolean visited[] = new boolean[adj.size()];
        q.add (start);
        visited[start] = true;
        int node = start;
        int dist = 0;
        while (!q.isEmpty ()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int u = q.poll();

                for (int v : adj.get(u)) {
                    if (!visited[v]) {
                        visited[v] = true;
                        node = v;
                        q.add (v);
                    }
                }
            }
            if (!q.isEmpty()) dist++;
        }
        return new int[] {node, dist};
    } 
    private int treeDiameter (int u, List<List<Integer>> adj) {
        int oneEnd[] = bfs (u, adj);
        int diameter[] = bfs (oneEnd[0], adj);
        return diameter[1];
    }
    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        int n = edges1.length + 1;
        List<List<Integer>> adj1 = new ArrayList<>();
        for (int i = 0; i < n; i++) adj1.add(new ArrayList<>());
        for (int e[] : edges1) {
            int u = e[0];
            int v = e[1];
            adj1.get(u).add(v);
            adj1.get(v).add(u);
        }
        int dia1 = treeDiameter (0, adj1);

        int m = edges2.length + 1;
        List<List<Integer>> adj2 = new ArrayList<>();
        for (int i = 0; i < m; i++) adj2.add(new ArrayList<>());
        for (int e[] : edges2) {
            int u = e[0];
            int v = e[1];
            adj2.get(u).add(v);
            adj2.get(v).add(u);
        }
        int dia2 = treeDiameter (0, adj2);

        int ans = ((dia1 + 1) / 2) + ((dia2 + 1) / 2) + 1; 
        ans = Math.max (dia1, Math.max (dia2, ans));
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna