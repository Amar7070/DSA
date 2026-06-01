class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int n = cost.length;
        int ans = 0;
        int count = 0;
        for(int i = n - 1; i >= 0; i--) {
            if(count < 2) {
                ans += cost[i];
                count++;
            }
            else {
                count = 0;
            }
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna