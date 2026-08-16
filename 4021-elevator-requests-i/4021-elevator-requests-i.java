class Solution {
    public int elevatorRequests(int n, int[] requests) {
        int ans = requests[0];
        int prev = requests[0];
        for (int r : requests) {
            ans += Math.abs(prev - r);
            prev = r;
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna