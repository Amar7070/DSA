class Solution {
    public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
        int n = rowCosts.length;
        int m = colCosts.length;
        int r1 = startPos[0], c1 = startPos[1];
        int r2 = homePos[0], c2 = homePos[1];
        
        int ans = 0;
        if (r1 <= r2) {
            for (int i = r1 + 1; i <= r2; i++) {
                ans += rowCosts[i];
            }
        }
        else {
            for (int i = r1 - 1; i >= r2; i--) {
                ans += rowCosts[i];
            }
        }

        if (c1 <= c2) {
            for (int i = c1 + 1; i <= c2; i++) {
                ans += colCosts[i];
            }
        }
        else {
            for (int i = c1 - 1; i >= c2; i--) {
                ans += colCosts[i];
            }
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna