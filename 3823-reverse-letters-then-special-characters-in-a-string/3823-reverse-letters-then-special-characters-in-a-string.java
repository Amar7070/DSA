class Solution {
    public String reverseByType(String s) {
        StringBuilder lower = new StringBuilder();
        StringBuilder special = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (Character.isLowerCase(ch)) {
                lower.append (ch);
            } 
            else special.append (ch);
        }

        StringBuilder ans = new StringBuilder();
        int k = lower.length() - 1, j = special.length() - 1;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isLowerCase(ch)) {
                ans.append (lower.charAt(k--));
            } 
            else ans.append (special.charAt(j--));
        }

        return ans.toString();
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna