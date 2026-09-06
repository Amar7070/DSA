class Solution {
    public int countRotations(String s, int k) {
        int n = s.length();
        s = s + s;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = i; j < i + n - 1; j++) {
                if (s.charAt(j) == s.charAt(j + 1)) {
                    count++;
                }
            }
            if (count == k) ans++;
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna