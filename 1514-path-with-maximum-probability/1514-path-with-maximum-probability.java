class Pair {
    int to;
    double prob;
    Pair (int to, double prob) {
        this.to = to;
        this.prob = prob;
    }
}

class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<List<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(new Pair(v, succProb[i]));
            adj.get(v).add(new Pair(u, succProb[i]));
        }

        double dist[] = new double[n];
        Arrays.fill (dist, Double.MIN_VALUE);
        dist[start_node] = 1;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Double.compare(b.prob, a.prob));
        pq.add(new Pair (start_node, 1));

        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            int u = p.to;
            double probability = p.prob;

            if (probability < dist[u]) continue;
            if (u == end_node) return probability;

            for (Pair e : adj.get(u)) {
                int v = e.to;
                double prob = e.prob;

                if (dist[u] * prob > dist[v]) {
                    dist[v] = dist[u] * prob;
                    pq.add(new Pair(v, dist[v]));
                }
            }
        }
        return 0;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna