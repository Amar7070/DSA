class Pair {
    int row;
    int col;
    int move;
    Pair (int row, int col, int move) {
        this.row = row;
        this.col = col;
        this.move = move;
    }
}
class Solution {
    public boolean canReach(int[] start, int[] target) {
        int dr[] = {2, 1, -1, -2, -2, -1, 1, 2};
        int dc[] = {1, 2, 2, 1, -1, -2, -2, -1};
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(start[0], start[1], 0));
        boolean visited[][] = new boolean[8][8];
        visited[start[0]][start[1]] = true;

        while (!q.isEmpty()) {
            Pair p = q.poll();
            int row = p.row;
            int col = p.col;
            int move = p.move;
            if (row == target[0] && col == target[1] && move % 2 == 0) return true;
            for (int i = 0; i < 8; i++) {
                int r = row + dr[i];
                int c = col + dc[i];
                if (r >= 0 && r < 8 && c >= 0 && c < 8 && !visited[r][c]) {
                    q.add(new Pair(r, c, move + 1));
                    visited[r][c] = true;
                }
            }
        }
        return false;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna