class Pair {
    int row;
    int col;
    int effort;
    Pair (int row, int col, int effort) {
        this.row = row;
        this.col = col;
        this.effort = effort;
    }
}
class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        PriorityQueue<Pair> q = new PriorityQueue<>((a, b) -> a.effort - b.effort);
        int dist[][] = new int[n][m];
        for (int i = 0; i < n; i++) Arrays.fill(dist[i], Integer.MAX_VALUE);
        dist[0][0] = 0;
        q.add(new Pair(0, 0, 0));
        int dr[] = {1, 0, -1, 0};
        int dc[] = {0, 1, 0, -1};
        while(!q.isEmpty()){
            Pair p = q.poll();
            int row = p.row;
            int col = p.col;
            int e = p.effort;
            if(e > dist[row][col]) continue;
            if(row == n - 1 && col == m - 1) return e;
            for(int i = 0; i < 4; i++){
                int r = row + dr[i];
                int c = col + dc[i];
                if(r >= 0 && c >= 0 && r < n && c < m){
                    int ti = Math.max(e, Math.abs(heights[r][c] - heights[row][col]));
                    if(ti < dist[r][c]){
                        dist[r][c] = ti;
                        q.add(new Pair(r,c,ti));
                    }
                }
            }
        }
        return -1;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna