class Solution {
    public String sortString(String s) {
        int n = s.length();

        StringBuilder sb = new StringBuilder();

        int freq[] = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        while (true) {
            boolean flag = true;

            for (int i = 0; i < 26; i++) {
                if (freq[i] > 0) {
                    char ch = (char)(i + 'a');
                    sb.append (ch);
                    freq[i]--;
                    flag = false;
                }
            }

            if (flag) break;

            for (int i = 25; i >= 0; i--) {
                if (freq[i] > 0) {
                    char ch = (char)(i + 'a');
                    sb.append (ch);
                    freq[i]--;
                    flag = true;
                }
            }

            if (!flag) break;
        }
        return sb.toString();
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna