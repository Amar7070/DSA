class Solution {
    public String trimTrailingVowels(String s) {
        StringBuilder sb = new StringBuilder(s);
        int i = sb.length() - 1;
        while (i >= 0 && (sb.charAt(i) == 'a' || sb.charAt(i) == 'e' || sb.charAt(i) == 'i' || sb.charAt(i) == 'o' || sb.charAt(i) == 'u')) {
            sb.deleteCharAt(i--);
        }
        return sb.toString();
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna