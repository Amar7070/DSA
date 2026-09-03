class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = profit.length;
        int temp[][] = new int[n][3];
        for (int i = 0; i < n; i++) {
            temp[i][0] = startTime[i];
            temp[i][1] = endTime[i];
            temp[i][2] = profit[i];
        }

        int dp[] = new int[n];
        Arrays.fill (dp, -1);

        Arrays.sort(temp, (a, b) -> Integer.compare(a[0], b[0]));

        return solve (0, temp, dp);
    }

    private int solve (int idx, int[][] temp, int dp[]) {
        int n = temp.length;
        if (idx >= n) return 0;

        if (dp[idx] != -1) return dp[idx];

        int next = getNextIdx (temp, idx + 1, n - 1, temp[idx][1]);
        int take = temp[idx][2] + solve (next, temp, dp);
        int notTake = solve (idx + 1, temp, dp);

        return dp[idx] = Math.max (take, notTake);
    }

    private int getNextIdx (int temp[][], int l, int r, int t) {
        int ans = temp.length;
        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (temp[mid][0] >= t) {
                r = mid - 1;
                ans = mid;
            }
            else l = mid + 1;
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna