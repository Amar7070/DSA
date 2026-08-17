class Solution {
    int []prefix;
    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;

        prefix = new int[n];
        prefix[0] = stoneValue[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + stoneValue[i];
        }

        int dp[][] = new int[n][n];
        for (int i = 0; i < n; i++) Arrays.fill (dp[i], -1);
        return solve (0, n - 1, stoneValue, dp);
    }

    private int getSum (int a, int b) {
        return (a > 0) ? prefix[b] - prefix[a - 1] : prefix[b];
    }

    private int solve (int i, int j, int[] stoneValue, int[][] dp) {
        if (i == j) return 0;

        if (dp[i][j] != -1) return dp[i][j];
        
        int ans = 0;

        for (int k = i; k < j; k++) {
            int left = getSum (i, k);
            int right = getSum (k + 1, j);

            if (left < right) {
                ans = Math.max (ans, left + solve (i, k, stoneValue, dp));
            }

            else if (right < left) {
                ans = Math.max (ans, right + solve (k + 1, j, stoneValue, dp));
            }

            else {
                ans = Math.max (ans, left + Math.max (solve (i, k, stoneValue, dp), solve (k + 1, j, stoneValue, dp)));
            }
        }
        
        return dp[i][j] = ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna