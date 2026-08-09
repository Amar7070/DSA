class Solution {
    private int solve (int i, int[] piles, int turn, int m, int dp[][][]) {
        int n = piles.length;
        if (i >= n) return 0;
        if (dp[turn][i][m] != -1) return dp[turn][i][m];
        int stone = 0;
        int ans = turn == 0 ? Integer.MIN_VALUE : Integer.MAX_VALUE;

        for (int x = 1; x <= Math.min(2 * m, n - i); x++) {
            stone += piles[i + x - 1];

            if (turn == 0) {
                ans = Math.max (ans, stone + solve (x + i, piles, 1, Math.max(m, x), dp));
            }
            else {
                ans = Math.min (ans, solve (x + i, piles, 0, Math.max(m, x), dp));
            }
        } 
        return dp[turn][i][m] = ans;
    }
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int sum = 0;
        for (int i = 0; i < n; i++) sum += piles[i];

        int dp[][][] = new int[2][n][n + 1];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < n; j++) Arrays.fill(dp[i][j], -1);
        }

        return solve (0, piles, 0, 1, dp);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna