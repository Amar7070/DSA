class Solution {
    public long maximumValue(int n, int s, int m) {
        long ans = s;
        if (n >= 2) {
            ans += m;
            n -= 2;
            ans += 1L * (n / 2) * (m - 1);
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna