class Pair {
    int first;
    int second;
    Pair (int first, int second) {
        this.first = first;
        this.second = second;
    }
}
class Solution {
    public int[] maxPoints(int[][] grid, int[] queries) {
        int n = grid.length;
        int m = grid[0].length;
        int q = queries.length;
        int ans[] = new int[q];
        Pair p[] = new Pair[q];
        for (int i = 0; i < q; i++) p[i] = new Pair(queries[i], i);

        Arrays.sort (p, (a, b) -> a.first - b.first);
        int freq[] = new int[q];
        boolean visited[][] = new boolean[n][m];
        PriorityQueue<int[]> dq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int idx = 0;
        while (idx < q && p[idx].first <= grid[0][0]) idx++;
        if (idx >= q) return freq;
        dq.add (new int[] {grid[0][0], 0, 0});
        visited[0][0] = true;
        int dr[] = {0, 1, 0, -1};
        int dc[] = {1, 0, -1, 0};
        int count = 0;
        while (idx < q && !dq.isEmpty()) {
            int curr[] = dq.poll();
            int value = curr[0];
            int row = curr[1];
            int col = curr[2];
            while (idx < q && grid[row][col] >= p[idx].first) {
                freq[idx++] = count; 
            }
            if (idx >= q) break;
            if (grid[row][col] < p[idx].first) {
                count++;
            }
            for (int i = 0; i < 4; i++) {
                int r = row + dr[i];
                int c = col + dc[i];
                if (r < 0 || c < 0 || r >= n || c >= m || visited[r][c]) continue;
                dq.add (new int[] {grid[r][c], r, c});
                visited[r][c] = true;
            }
            
        }
        while (idx < q) freq[idx++] = count;
        for (int i = 0; i < q; i++) {
            ans[p[i].second] = freq[i];
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna