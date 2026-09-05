class Solution {
    int mod = 1000000007;
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int total = 0;

        int dp[][][] = new int[profit.length][n + 1][minProfit + 1];

        for (int i = 0; i < profit.length; i++) {
            for (int j = 0; j <= n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return solve (0, n, minProfit, group, profit, 0, dp);
    }

    int solve (int i, int n, int minProfit, int[] group, int[] profit, int total, int dp[][][]) {
        if (i == profit.length) {
            if (total >= minProfit) return 1;
            return 0;
        }

        if (dp[i][n][total] != -1) return dp[i][n][total];
        int take = 0;
        if (n >= group[i]) {
            int cappedTotal = Math.min(minProfit, total + profit[i]);
            take = solve (i + 1, n - group[i], minProfit, group, profit, cappedTotal, dp);
        }
        int notTake = solve (i + 1, n, minProfit, group, profit, total, dp);

        return dp[i][n][total] = (take + notTake) % mod;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna