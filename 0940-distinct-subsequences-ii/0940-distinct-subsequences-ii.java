class Solution {
    int mod = 1000000007;
    public int distinctSubseqII(String s) {
        int n = s.length();
        int last[] = new int[26];
        Arrays.fill (last, -1);

        int dp[] = new int[n + 1];

        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            char ch = s.charAt(i - 1);
            dp[i] = (dp[i - 1] * 2) % mod;

            if (last[ch - 'a'] != -1) {
                dp[i] = (dp[i] - dp[last[ch - 'a'] - 1] + mod) % mod;
            }

            last[ch - 'a'] = i;
        }

        return (dp[n] - 1 + mod) % mod;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna