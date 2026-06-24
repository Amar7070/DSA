class Solution {
    public int characterReplacement(String s, int k) {
        int freq[] = new int[26];
        int maxF = 0;
        int ans = 0;
        int l = 0, r = 0;
        while(r < s.length()) {
            int right = s.charAt(r) - 'A';
            freq[right]++;
            maxF = Math.max(maxF, freq[right]);
            while((r - l + 1) - maxF > k) {
                int left = s.charAt(l) - 'A';
                freq[left]--;
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