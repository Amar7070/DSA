class Solution {
    public int hammingWeight(int n) {
        int ans = 0;
        while(n > 0) {
            if((n & 1) == 1) ans++;
            n >>= 1;
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna