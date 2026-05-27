class Solution {
    public int numberOfSpecialChars(String word) {
        int lo[] = new int[26];
        int up[] = new int[26];
        Arrays.fill(lo, Integer.MAX_VALUE);
        Arrays.fill(up, -1);
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if(Character.isLowerCase(ch)) lo[ch - 'a'] = i;
            else {
                if(up[ch - 'A'] == -1) up[ch - 'A'] = i;
            }
        }
        int ans = 0;
        for(int i = 0; i < 26; i++) {
            if(lo[i] < up[i]) ans++;
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna