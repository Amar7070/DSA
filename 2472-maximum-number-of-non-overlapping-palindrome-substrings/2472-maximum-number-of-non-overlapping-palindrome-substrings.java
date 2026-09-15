class Solution {
    public int maxPalindromes(String s, int k) {
        int n = s.length();
        if (k == 1) return n;

        boolean isPalindrome[][] = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            isPalindrome[i][i] = true;
        }

        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                isPalindrome[i][i + 1] = true;
            }
        }

        for (int len = 3; len <= n; len++) {
            for (int i = 0; i < n - len + 1; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j) && isPalindrome[i + 1][j - 1]) {
                    isPalindrome[i][j] = true;
                }
            }
        }

        int dp[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }        


        return solve (0, k - 1, s, k, isPalindrome, dp);
    }
    private int solve (int i, int j, String s, int k, boolean[][] isPalindrome, int dp[][]) {
        if (j >= s.length()) {
            return 0;
        }

        if (dp[i][j] != -1) return dp[i][j];
        int ans = 0;

        if (isPalindrome[i][j]) {
            ans = 1 + solve(j + 1, j + 1 + k - 1, s, k, isPalindrome, dp);
        }

        ans = Math.max(ans, Math.max (solve(i, j + 1, s, k, isPalindrome, dp), solve (i + 1, j + 1, s, k, isPalindrome, dp)));

        return dp[i][j] = ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna