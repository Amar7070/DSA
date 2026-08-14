class Solution {
    public int maximumLengthSubstring(String s) {
        int n = s.length();
        int freq[] = new int[26];

        int l = 0;
        int r = 0;
        int ans = 0;
        while (r < n) {
            char ch = s.charAt(r);
            freq[ch - 'a']++;

            while (freq[ch - 'a'] > 2) {
                char left = s.charAt(l);
                freq[left - 'a']--;
                l++;
            }
            
            ans = Math.max(ans, r - l + 1);
            r++;
        }

        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna