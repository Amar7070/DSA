class Solution {
    int mod = 1000000007;
    public int numberOfSets(int n, int k) {
        int dp[][] = new int[n + 1][k + 1];
        // if (k == n - 1) return 1;
        for (int i = 0; i < n; i++) {
            dp[i][k] = 1;
        }
        
        for (int count = k - 1; count >= 0; count--) {
            long sum = 0;
            for (int i = n - 1; i >= 0; i--) {
                dp[i][count] = dp[i + 1][count];
                if (i + 1 < n) {
                    sum = (sum + dp[i + 1][count + 1]) % mod;
                }
                dp[i][count] = (int) ((dp[i][count] + sum) % mod);
            }
        }

        return dp[0][0];
    }

    // private int solve (int i, int n, int k, int count, int dp[][]) {
    //     if (count >= k) return 1;

    //     if (i >= n) {
    //         return 0;
    //     }

    //     if (dp[i][count] != -1) return dp[i][count];

    //     int ans = solve (i + 1, n, k, count, dp);
        
    //     for (int j = i + 1; j < n; j++) {
    //         ans = (ans + solve (j, n, k, count + 1, dp)) % mod;
    //     }
        
    //     return dp[i][count] = ans;
    // }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna