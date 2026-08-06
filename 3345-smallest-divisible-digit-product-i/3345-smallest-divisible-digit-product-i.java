class Solution {
    public int smallestNumber(int n, int t) {
        while (n <= 100) {
            int temp = n;
            long prod = 1;
            while (temp > 0) {
                int l = temp % 10;
                prod *= l;
                temp /= 10;
            } 
            if (prod % t == 0) return n;
            n++; 
        }
        return -1;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna