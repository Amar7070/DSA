class Solution {
    public String removeDuplicateLetters(String s) {
        int n = s.length();
        int lastIdx[] = new int[26];
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            lastIdx[ch - 'a'] = i;
        }

        StringBuilder sb = new StringBuilder();
        boolean avail[] = new boolean[26];

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (avail[ch - 'a']) continue;

            // char c = ;

            while (!sb.isEmpty() && sb.charAt(sb.length() - 1) > ch && lastIdx[sb.charAt(sb.length() - 1) - 'a'] > i) {
                avail[sb.charAt(sb.length() - 1) - 'a'] = false;
                sb.deleteCharAt(sb.length() - 1);
                
            }

            sb.append(ch);
            avail[ch - 'a'] = true;
        }
        return sb.toString();
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna