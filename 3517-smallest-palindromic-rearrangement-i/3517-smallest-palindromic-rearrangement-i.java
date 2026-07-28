class Solution {
    public String smallestPalindrome(String s) {
        int n = s.length();
        char ch[] = s.toCharArray();
        int mid = n / 2;
        Arrays.sort (ch, 0, mid);
        for (int i = 0; i < mid; i++) {
            ch[n - i - 1] = ch[i];
        }
        return String.valueOf(ch);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna