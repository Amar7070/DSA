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

        int dp[] = new int[n];

        Arrays.fill(dp, -1);        

        return solve (0, s, k, isPalindrome, dp);
    }
    private int solve (int i, String s, int k, boolean[][] isPalindrome, int dp[]) {
        if (i >= s.length()) {
            return 0;
        }

        if (dp[i] != -1) return dp[i];

        int ans = solve (i + 1, s, k, isPalindrome, dp);

        for (int j = i + k - 1; j < s.length(); j++) {
            if (isPalindrome[i][j]) {
                ans = Math.max (ans, 1 + solve (j + 1, s, k, isPalindrome, dp));
            }
        }

        return dp[i] = ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna