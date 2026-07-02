class Pair {
    int row;
    int col;
    int health;
    Pair (int row, int col, int health) {
        this.row = row;
        this.col = col;
        this.health = health;
    }
}
class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int n = grid.size();
        int m = grid.get(0).size();
        Queue<Pair> q = new ArrayDeque<>();
        int startHealth = health - grid.get(0).get(0);
        if (startHealth <= 0) return false;
        q.add(new Pair(0, 0, startHealth));
        int dr[] = {-1, 0, 1, 0};
        int dc[] = {0, 1, 0, -1};
        int[][] best = new int[n][m];
        for (int i =0; i < n; i++) Arrays.fill(best[i], -1);
        best[0][0] = startHealth;
        while (!q.isEmpty()) {
            Pair p = q.poll();
            int row = p.row;
            int col = p.col;
            int h = p.health;
            if(h < 1) continue;
            if(row == n - 1 && col == m - 1) return h > 0;
            for (int i = 0; i < 4; i++) {
                int r = row + dr[i];
                int c = col + dc[i];
                if(r < 0 || c < 0 || r >= n || c >= m) continue;
                int nh = h - grid.get(r).get(c);
                if (nh > 0 && nh > best[r][c]) {
                    best[r][c] = nh;
                    q.offer(new Pair(r, c, nh));
                }
            }
        }
        return false;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna