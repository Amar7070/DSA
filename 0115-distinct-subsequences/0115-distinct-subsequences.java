class Solution {
    private int solve(int i, int j, String s, String t, int dp[][]) {
        if (j == t.length()) return 1;
        if (i == s.length()) return 0;

        if (dp[i][j] != -1) return dp[i][j];
        
        int ans = 0;
        if (s.charAt(i) == t.charAt(j)) {
            ans += solve(i + 1, j + 1, s, t, dp);
        }

        ans += solve(i + 1, j, s, t, dp);

        return dp[i][j] = ans;
    }
    public int numDistinct(String s, String t) {
        int dp[][] = new int[s.length()][t.length()];

        for (int i = 0; i < s.length(); i++) {
            Arrays.fill(dp[i], -1);
        }
        return solve(0, 0, s, t, dp);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna