class Solution {
    public double minPrice(int[] prices, int[] discounts) {
        int n = prices.length;
        int m = discounts.length;
        double ans = 0;
        Arrays.sort (prices);
        Arrays.sort (discounts);
        int i = n - 1, j = m - 1;
        while (i >= 0 && j >= 0) {
            ans += prices[i] * (100 - discounts[j]) / 100.0;
            i--;
            j--;
        }
        while (i >= 0) {
            ans += prices[i];
            i--;
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna