class Solution {
    int mod = 1000000007;
    public int numberOfSets(int n, int k) {
        int dp[][] = new int[n][k + 1];
        if (k == n - 1) return 1;
        for (int i = 0; i < n; i++) Arrays.fill (dp[i], -1);
        return solve (0, n, k, 0, dp);
    }

    private int solve (int i, int n, int k, int count, int dp[][]) {
        if (count >= k) return 1;

        if (i >= n) {
            return 0;
        }

        if (dp[i][count] != -1) return dp[i][count];

        int ans = solve (i + 1, n, k, count, dp);
        
        for (int j = i + 1; j < n; j++) {
            ans = (ans + solve (j, n, k, count + 1, dp)) % mod;
        }
        
        return dp[i][count] = ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna