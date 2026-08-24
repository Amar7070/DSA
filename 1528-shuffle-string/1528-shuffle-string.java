class Solution {
    public String restoreString(String s, int[] indices) {
        int n = s.length();
        char ans[] = new char[n];
        for (int i = 0; i < n; i++) {
            ans[indices[i]] = s.charAt(i);
        }
        return new String(ans);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna