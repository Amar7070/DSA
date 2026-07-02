class Solution {
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int ans = 0;
        int dp[][] = new int[n][m];
        for (int i = 0 ; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '1') {
                    if(i == 0 || j == 0) dp[i][j] = 1;
                    else {
                        dp[i][j] = 1 + Math.min(dp[i - 1][ j - 1], 
                                                Math.min(dp[i - 1][j], dp[i][j - 1]));
                    }
                }
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans * ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna