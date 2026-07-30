class Solution {
    private int solve (int n, int m, int[][] grid, int dp[][]) {
        if (n < 0 || m < 0) return Integer.MAX_VALUE;

        if (n == 0 && m == 0) return grid[0][0];

        if (dp[n][m] != -1) return dp[n][m];
        int left = solve (n, m - 1, grid, dp);
        int up = solve (n - 1, m, grid, dp);

        return dp[n][m] = grid[n][m] + Math.min(left, up); 
    }
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int dp[][] = new int[n][m];
        for (int i = 0; i < n; i++) Arrays.fill(dp[i], -1);

        return solve (n - 1, m - 1, grid, dp);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna