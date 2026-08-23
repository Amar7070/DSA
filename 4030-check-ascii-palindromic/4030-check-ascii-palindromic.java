class Solution {
    public boolean isPalindromic(String s) {
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            char x = c;

            for (int i = 7; i >= 0; i--) {
                sb.append((x >> i) & 1);
            }
        }

        int l = 0;
        int r = sb.length() - 1;
        while (l < r) {
            if (sb.charAt(l) != sb.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna