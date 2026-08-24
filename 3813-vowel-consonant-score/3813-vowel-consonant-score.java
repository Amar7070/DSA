class Solution {
    public int vowelConsonantScore(String s) {
        int n = s.length();
        int v = 0;
        int c = 0;
        for (int i = 0; i < n; i++){
            char ch = s.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'u' || ch == 'o'){
                v++;
            }
            else if (Character.isLetter(ch)) c++;
        }
        return c > 0 ? v / c : 0;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna