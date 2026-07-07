class Solution {
    public long sumAndMultiply(int n) {
        int sum = 0;
        long mul = 0;
        String s = String.valueOf(n);
        for (int i = 0; i < s.length(); i++) {
            int ch = s.charAt(i) - '0';
            if (ch != 0) {
                mul = mul * 10 + ch;
                sum += ch;
            }
        }
        return mul * sum;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna