class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int indeg[] = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());

        for (int p[] : prerequisites) {
            int u = p[0];
            int v = p[1];
            indeg[v]++;
            adj.get(u).add(v);
        }
        
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (indeg[i] == 0) q.add(i);
        }

        int count = 0;
        while (!q.isEmpty()) {
            int u = q.poll();

            for (int v : adj.get(u)) {
                indeg[v]--;
                if (indeg[v] == 0) q.add(v);
            }

            count++;
        }

        return count == numCourses;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna