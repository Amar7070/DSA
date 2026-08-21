class Solution {
    public String replaceDigits(String s) {
        char ch[] = s.toCharArray(); 
        int n = ch.length;
        for (int i = 1; i < n; i += 2) {
            ch[i] = (char)(ch[i - 1] + (ch[i] - '0'));
        }
        return new String(ch);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna