class Solution {
    public int maxDistance(String moves) {
        int l = 0, r = 0, u = 0, d = 0, under = 0;
        for(char ch : moves.toCharArray()) {
            if(ch == 'L') l++;
            else if(ch == 'R') r++;
            else if(ch == 'U') u++;
            else if(ch == 'D') d++;
            else under++;
        }
        return Math.abs(r - l) + Math.abs(u - d) + under;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna