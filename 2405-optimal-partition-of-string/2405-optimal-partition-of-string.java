class Solution {
    public int partitionString(String s) {
        int n = s.length();
        char chars[] = s.toCharArray();

        boolean seen[] = new boolean[26];

        int ans = 0;

        for (int i = 0; i < n; i++) {
            char ch = chars[i];
            if (seen[ch - 'a']) {
                ans++;
                Arrays.fill(seen, false);
            }
            seen[ch - 'a'] = true;
        }

        for (int i = 0; i < 26; i++) {
            if (seen[i]) {
                ans++;
                break;
            }
        }

        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna