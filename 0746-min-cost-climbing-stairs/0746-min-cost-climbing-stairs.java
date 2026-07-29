class Solution {
    private int solve (int i, int[] cost, int[] dp) {
        if (i >= cost.length) return 0;
        if (dp[i] != -1) return dp[i];

        return dp[i] = cost[i] + Math.min (solve (i + 1, cost, dp), solve (i + 2, cost, dp));
    }
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        
        int dp[] = new int[n];
        Arrays.fill(dp, -1);

        int cost1 = solve (0, cost, dp);
        int cost2 = solve (1, cost, dp);

        return Math.min(cost1, cost2);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna