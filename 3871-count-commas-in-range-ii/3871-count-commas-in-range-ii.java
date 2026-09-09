class Solution {
    public long countCommas(long n) {
        long l = 1000;
        long r = 1000000 - 1;
        long ans = 0;
        int comma = 1;
        while (l <= n){
            ans += (Math.min(n, r) - l + 1) * comma;
            comma++;
            l *= 1000;
            r = (r + 1) * 1000 - 1;
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna