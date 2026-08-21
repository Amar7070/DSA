class Solution {
    public String replaceDigits(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < n; i += 2) {
            sb.append(s.charAt(i - 1));
            char ch = (char)(s.charAt(i - 1) + (s.charAt(i) - '0'));
            sb.append(ch);
        }
        if (n % 2 != 0) sb.append(s.charAt(n - 1));
        return sb.toString();
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna