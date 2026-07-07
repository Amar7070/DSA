class Solution {
    public long sumAndMultiply(int n) {
        int sum = 0;
        long mul = 0;
        long place = 1;
        while (n > 0) {
            int d = n % 10;

            if (d != 0) {
                mul += d * place;
                sum += d;
                place *= 10;
            }
            n /= 10;
        }
        return mul * sum;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna