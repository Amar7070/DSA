class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Long.compare(
                (long)b[0] * b[0] + (long)b[1] * b[1],
                (long)a[0] * a[0] + (long)a[1] * a[1]
            )
        );

        for (int[] point : points) {
            pq.offer(point);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[][] ans = new int[k][2];
        for (int i = 0; i < k; i++) {
            ans[i] = pq.poll();
        }

        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna