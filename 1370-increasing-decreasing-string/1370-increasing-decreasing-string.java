class Solution {
    public String sortString(String s) {
        int n = s.length();

        StringBuilder sb = new StringBuilder();

        int freq[] = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }
        int count = 0;
        while (count < n) {
            for (int i = 0; i < 26; i++) {
                if (freq[i] > 0) {
                    char ch = (char)(i + 'a');
                    sb.append (ch);
                    freq[i]--;
                    count++;
                }
            }

            for (int i = 25; i >= 0; i--) {
                if (freq[i] > 0) {
                    char ch = (char)(i + 'a');
                    sb.append (ch);
                    freq[i]--;
                    count++;
                }
            }
        }
        return sb.toString();
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna