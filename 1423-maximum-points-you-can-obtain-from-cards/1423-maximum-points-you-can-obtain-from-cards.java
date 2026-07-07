class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int ls = 0;
        for (int i = 0; i < k; i++) {
            ls += cardPoints[i];
        }
        int rs = 0;
        int r = cardPoints.length - 1;
        int ans = ls;
        for (int i = k - 1; i >= 0; i--) {
            ls -= cardPoints[i];
            rs += cardPoints[r--];
            ans = Math.max(ans, ls + rs);
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna