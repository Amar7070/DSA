class Solution {
    int res = Integer.MAX_VALUE;
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        if (d > n) return -1;

        int memo[][] = new int[n][d + 1];

        for (int i = 0; i < n; i++) Arrays.fill(memo[i], -1);

        return solve (0, jobDifficulty, d, memo);
    }

    private int solve (int idx, int[] jobDiff, int d, int[][] memo) {
        int n = jobDiff.length;
        if (d == 1) {
            int max = 0;
            for (int i = idx; i < n; i++) {
                max = Math.max (max, jobDiff[i]);
            }
            return max;
        }

        if (memo[idx][d] != -1) return memo[idx][d];

        int maxDiff = 0;
        int totalMinDiff = Integer.MAX_VALUE;

        for (int i = idx; i <= n - d; i++) {
            maxDiff = Math.max (maxDiff, jobDiff[i]);
            int nextDayJob = solve (i + 1, jobDiff, d - 1, memo);
            if (nextDayJob != Integer.MAX_VALUE) {
                totalMinDiff = Math.min (totalMinDiff, maxDiff + nextDayJob);
            }
        }

        return memo[idx][d] = totalMinDiff;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna