class Solution {
    public double angleClock(int hour, int minutes) {
        double ans = Math.abs(30 * hour - 5.5 * minutes);
        return (ans > 180) ? 360 - ans : ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna