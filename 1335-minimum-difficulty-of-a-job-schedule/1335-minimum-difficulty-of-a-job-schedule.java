class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        if (d > n) return -1;

        int memo[][] = new int[n + 1][d + 1];

        // memo[i][day] = minimum difficulty to schedule first i jobs in exactly 'day' days

        for (int i = 0; i <= n; i++) Arrays.fill(memo[i], Integer.MAX_VALUE);

        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max (max, jobDifficulty[i - 1]);

            memo[i][1] = max; 
        }

        for (int day = 2; day <= d; day++) {

            for (int i = day; i <= n; i++) {

                int maxDiff = 0;

                for (int j = i - 1; j >= day - 1; j--) {
                    maxDiff = Math.max (maxDiff, jobDifficulty[j]);   // current day

                    memo[i][day] = Math.min (memo[i][day], memo[j][day - 1] + maxDiff);
                }
            }
        }

        return memo[n][d];
    }

    // private int solve (int idx, int[] jobDiff, int d, int[][] memo) {
    //     int n = jobDiff.length;
    //     if (d == 1) {
    //         int max = 0;
    //         for (int i = idx; i < n; i++) {
    //             max = Math.max (max, jobDiff[i]);
    //         }
    //         return max;
    //     }

    //     if (memo[idx][d] != -1) return memo[idx][d];

    //     int maxDiff = 0;
    //     int totalMinDiff = Integer.MAX_VALUE;

    //     for (int i = idx; i <= n - d; i++) {
    //         maxDiff = Math.max (maxDiff, jobDiff[i]);
    //         int nextDayJob = solve (i + 1, jobDiff, d - 1, memo);
    //         if (nextDayJob != Integer.MAX_VALUE) {
    //             totalMinDiff = Math.min (totalMinDiff, maxDiff + nextDayJob);
    //         }
    //     }

    //     return memo[idx][d] = totalMinDiff;
    // }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna