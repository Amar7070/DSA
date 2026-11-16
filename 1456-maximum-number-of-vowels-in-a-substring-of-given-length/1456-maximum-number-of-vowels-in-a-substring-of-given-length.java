class Solution {
    public int maxVowels(String s, int k) {
        int n = s.length();
        int count = 0;

        for (int i = 0; i < k; i++) {
            if (isVowel(s.charAt(i))) count++;
        }

        if (count == k) return count;
        int ans = count;

        for (int i = k; i < n; i++) {
            if (isVowel(s.charAt(i - k))) count--;
            if (isVowel(s.charAt(i))) count++;

            ans = Math.max(ans, count);
        }

        return ans;
    }

    private boolean isVowel (char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna