class Pair {
    int row;
    int col;
    int d;      // distance from thief
    Pair (int row, int col, int d) {
        this.row = row;
        this.col = col;
        this.d = d;
    }
}
class Solution {
    private boolean isPossible(int mid, int mat[][]) {
        int n = mat.length;
        Queue<Pair> q = new ArrayDeque<>();
        boolean visited[][] = new boolean[n][n]; 
        q.add(new Pair(0, 0, 0));
        int dr[] = {-1, 0, 1, 0};
        int dc[] = {0, 1, 0, -1};
        while (!q.isEmpty()) {
            Pair p = q.poll();
            int row = p.row;
            int col = p.col;
            if (row == n - 1 && col == n - 1) return true;
            for (int i = 0; i < 4; i++) {
                int r = row + dr[i];
                int c = col + dc[i];
                if (r >= n || c >= n || r < 0 || c < 0 || visited[r][c] || mat[r][c] < mid) continue;
                q.add(new Pair(r, c, 0));
                visited[r][c] = true;
            }
        }
        return false;
    }

    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        int mat[][] = new int[n][n];
        Queue<Pair> q = new ArrayDeque<>();
        boolean visited[][] = new boolean[n][n]; 
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(grid.get(i).get(j) == 1) {
                    q.add(new Pair(i, j, 0));
                    visited[i][j] = true;
                }
            }
        }
        int max = 0;
        int dr[] = {-1, 0, 1, 0};
        int dc[] = {0, 1, 0, -1};
        while (!q.isEmpty()) {
            Pair p = q.poll();
            int row = p.row;
            int col = p.col;
            int d = p.d;
            for (int i = 0; i < 4; i++) {
                int r = row + dr[i];
                int c = col + dc[i];
                if (r >= n || c >= n || r < 0 || c < 0 || visited[r][c]) continue;
                max = Math.max(max, d + 1);
                mat[r][c] = d + 1;
                q.add(new Pair(r, c, d + 1));
                visited[r][c] = true;
            }
        }

        int l = 0, h = max;
        int ans = 0;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if(mat[0][0] >= mid && isPossible(mid, mat)) {
                ans = mid;
                l = mid + 1;
            }
            else h = mid - 1;
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna