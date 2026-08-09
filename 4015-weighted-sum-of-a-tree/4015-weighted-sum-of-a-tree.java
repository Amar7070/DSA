class Solution {
    public long weightedSum(int[] parent, int[] nums) {
        int n = parent.length;
        int[] depth = new int[n];
        Arrays.fill(depth, -1);

        int height = 0;
        for (int i = 0; i < n; i++) {
            int node = i;
            int d = 1;

            while (parent[node] != -1 && depth[node] == -1) {
                node = parent[node];
                d++;
            }
            if (depth[node] != -1) {
                d += depth[node] - 1;
            }
            node = i;
            int currentDepth = d;

            while (parent[node] != -1 && depth[node] == -1) {
                depth[node] = currentDepth--;
                node = parent[node];
            }

            if (parent[node] == -1 && depth[node] == -1) {
                depth[node] = 1;
            }

            height = Math.max(height, d);
        }

        long ans = 0;

        for (int i = 0; i < n; i++) {
            ans += 1L * nums[i] * (height - depth[i] + 1);
        }

        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna