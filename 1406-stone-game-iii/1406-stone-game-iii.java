class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int sum = 0;
        for (int i = 0; i < n; i++) sum += stoneValue[i];
        int dp[][] = new int[2][n];
        for (int i = 0; i < 2; i++) Arrays.fill(dp[i], Integer.MIN_VALUE);
        int a = solve (0, 0, stoneValue, dp);    // 0---> Alice ,  1 ---> Bob
        int b = sum - a;
        if (a == b) return "Tie";
        else if (a < b) return "Bob";
        return "Alice";
    }

    private int solve (int who, int i, int[] nums, int dp[][]) {
        int n = nums.length;
        if (i >= n) return 0;
        if (dp[who][i] != Integer.MIN_VALUE) return dp[who][i];
        int stone = 0;
        int ans = (who == 0) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        for (int x = 1; x <= Math.min(3, n - i); x++) {
            stone += nums[i + x - 1];

            if (who == 0) {
                ans = Math.max(ans, stone + solve (1, i + x, nums, dp));
            }
            else {
                ans = Math.min(ans, solve (0, i + x, nums, dp));
            }
        }
        return dp[who][i] = ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna