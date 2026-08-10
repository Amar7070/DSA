class Solution {
    public char findTheDifference(String s, String t) {
        int freq[] = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        for (char ch : t.toCharArray()) {
            if (freq[ch - 'a'] == 0) return ch;
            freq[ch - 'a']--;
        }
        return ' ';
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna