class Solution {
    public int maxProduct(int n) {
        int f = -1;
        int s = -1;
        while (n > 0) {
            int l = n % 10;
            if (f <= l) {
                s = f;
                f = l;
            }
            else if (s < l) {
                s = l;
            }
            n /= 10;
        }
        return f * s;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna