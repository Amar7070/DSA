class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        if (grid[0][0] == 1 || grid[n - 1][m - 1] == 1) return -1;
        Queue<int[]> q = new ArrayDeque<>();
        boolean visited[][] = new boolean[n][m];
        q.add(new int[]{0, 0, 1});

        int dr[] = {-1, -1, -1, 0, 0, 1, 1, 1};
        int dc[] = {-1, 0, 1, -1, 1, -1, 0, 1};
        while (!q.isEmpty()) {
            int curr[] = q.poll();
            int row = curr[0];
            int col = curr[1];
            int dist = curr[2];

            if (row == n - 1 && col == m - 1) return dist;
            
            for (int i = 0; i < 8; i++) {
                int r = row + dr[i];
                int c = col + dc[i];
                if (r < 0 || c < 0 || r >= n || c >= m || visited[r][c] || grid[r][c] == 1) continue;

                q.add (new int[] {r, c, dist + 1});
                visited[r][c] = true;
            }
        }
        return -1;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna