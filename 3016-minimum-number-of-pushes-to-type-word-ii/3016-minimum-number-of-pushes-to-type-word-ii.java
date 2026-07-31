class Solution {
    public int minimumPushes(String word) {
        int freq[] = new int[26];
        for (int ch : word.toCharArray()) {
            freq[ch - 'a']++;
        }
        Arrays.sort (freq);

        int ans = 0;
        int c = 1;
        int count = 0;
        for (int i = 25; i >= 0; i--) {
            if (freq[i] != 0) {
                ans += freq[i] * c;
                count ++;
                if (count == 8) {
                    c++;
                    count = 0;
                }
            }
        }
        return ans;

    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna