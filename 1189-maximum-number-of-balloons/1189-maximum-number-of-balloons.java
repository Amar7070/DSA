class Solution {
    public int maxNumberOfBalloons(String text) {
        String pat = "balloon";
        int fp[] = new int[26];
        for(char ch : pat.toCharArray()) {
            fp[ch - 'a']++;
        }
        int ft[] = new int[26];
        for(char ch : text.toCharArray()) {
            ft[ch - 'a']++;
        }
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < 26; i++) {
            if(fp[i] != 0) {
                ans = Math.min(ans, ft[i] / fp[i]);
            }
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna