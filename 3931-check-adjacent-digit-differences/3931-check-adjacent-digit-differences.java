class Solution {
    public boolean isAdjacentDiffAtMostTwo(String s) {
        int n = s.length();
        for(int i = 1; i < n; i++) {
            int a = s.charAt(i - 1);
            int b = s.charAt(i);
            if(Math.abs(a - b) > 2) return false;
        }
        return true;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna