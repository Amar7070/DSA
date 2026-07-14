class Solution {
    int mod = 1000000007;
    private int gcd (int a, int b) {
        if (b == 0) return a;
        return gcd (b, a % b);
    }
    private int solve (int[] nums, int idx, int gcd1, int gcd2, int dp[][][]) {
        if (idx == nums.length) {
            boolean bothNotEmpty = (gcd1 != 0 && gcd2 != 0);
            boolean isEqual = (gcd1 == gcd2);
            return (bothNotEmpty && isEqual) ? 1 : 0;
        }
        if (dp[idx][gcd1][gcd2] != -1) return dp[idx][gcd1][gcd2];

        int skip = solve (nums, idx + 1, gcd1, gcd2, dp);
        int take1 = solve (nums, idx + 1, gcd (nums[idx], gcd1), gcd2, dp);
        int take2 = solve (nums, idx + 1, gcd1, gcd (nums[idx], gcd2), dp);

        return  dp[idx][gcd1][gcd2] = (int)((0L + skip + take1 + take2) % mod);
    }
    public int subsequencePairCount(int[] nums) {
        int n = nums.length;
        int dp[][][] = new int[n][201][201];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= 200; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return solve (nums, 0, 0 , 0, dp);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna