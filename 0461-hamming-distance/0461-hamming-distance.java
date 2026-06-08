class Solution {
    public int hammingDistance(int x, int y) {
        int xorVal = x ^ y;
        int count = 0;
        while(xorVal != 0) {
            count += xorVal & 1;
            xorVal >>= 1;
        }
        return count;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna