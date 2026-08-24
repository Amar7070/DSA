class Solution {
    public int stoneGameVIII(int[] stones) {
        int n = stones.length;
        int prefix[] = new int[n];

        prefix[0] = stones[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + stones[i];
        }

        Integer dp[] = new Integer[n];
        
        return solve (1, prefix, dp);
    }

    private int solve (int i, int[] prefix, Integer dp[]) {
        if (i == prefix.length - 1) return prefix[i];

        if (dp[i] != null) return dp[i];

        int take = prefix[i] - solve (i + 1, prefix, dp);
        int notTake = solve (i + 1, prefix, dp);

        return dp[i] =  Math.max (take, notTake);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna