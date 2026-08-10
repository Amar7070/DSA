class Solution {
    private boolean solve(int turn, int n, Boolean dp[][]) {
        if (n == 0) return turn == 1;
        if (dp[turn][n] != null) return dp[turn][n];
        boolean ans = (turn == 1);
        for (int i = 1; i * i <= n; i++) {
            if (turn == 0) ans = ans || solve (1, n - i * i, dp);
            else ans = ans && solve (0, n - i * i, dp);
        }
        return dp[turn][n] = ans;
    }
    public boolean winnerSquareGame(int n) {
        Boolean dp[][] = new Boolean[2][n + 1];
        return solve (0, n, dp);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna