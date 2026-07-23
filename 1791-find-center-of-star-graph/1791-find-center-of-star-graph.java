class Solution {
    public int findCenter(int[][] edges) {
        int a = 0, b = 0;
        int ans = 0;
        for (int i = 0; i < 2; i++) {
            if (a == 0) {
                a = edges[i][0];
                b = edges[i][1];
            }
            else {
                if (a == edges[i][0] || a == edges[i][1]) ans = a;
                else ans = b;
            }
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna