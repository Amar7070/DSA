class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int k = s1.length();
        int n = s2.length();
        int freq[] = new int[26];
        for (int i = 0; i < k; i++) freq[s1.charAt(i) - 'a']++;
        int l = 0, r = 0;
        int count = k;

        while (r < n) {
            char right = s2.charAt(r);

            if (freq[right - 'a'] > 0) {
                count--;
            }
            freq[right - 'a']--;

            while (r - l + 1 > k) {
                char left = s2.charAt(l);

                freq[left - 'a']++;
                l++;
                if (freq[left - 'a'] > 0) count++;
            }

            if (count == 0) return true;
            r++;
        }

        return false;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna