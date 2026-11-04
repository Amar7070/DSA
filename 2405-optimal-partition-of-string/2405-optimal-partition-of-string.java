class Solution {
    public int partitionString(String s) {
        boolean[] seen = new boolean[26];
        int ans = 0;

        for (char ch : s.toCharArray()) {
            int idx = ch - 'a';
            if (seen[idx]) {
                ans++;
                Arrays.fill(seen, false);
            }
            seen[idx] = true;
        }

        return s.isEmpty() ? 0 : ans + 1;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna