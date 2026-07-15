class Solution {
    public int maximumPoints(int mat[][]) {
        // code here
        int n = mat.length;
        int dp[][] = new int[n][4];
        dp[0][0] = Math.max(mat[0][1], mat[0][2]);
        dp[0][1] = Math.max(mat[0][0], mat[0][2]);
        dp[0][2] = Math.max(mat[0][0], mat[0][1]);
        dp[0][3] = Math.max(mat[0][0], Math.max(mat[0][1], mat[0][2]));
        for (int day = 1; day < n; day++) {
            for (int lastTask = 0; lastTask < 4; lastTask++) {
                for (int i = 0; i < 3; i++) {
                    if (i != lastTask) {
                        int point = mat[day][i] + dp[day - 1][i];
                        dp[day][lastTask] = Math.max(dp[day][lastTask], point);
                    }
                }
            }
        }
        return dp[n - 1][3];
        // return solve (mat.length - 1, 3, mat, dp);
        
    }
    // private int solve (int idx, int lastTask, int[][] mat, int[][] dp) {
    //     if (idx == 0) {
    //         int max = 0;
    //         for (int i = 0; i <= 2; i++) {
    //             if (i != lastTask) {
    //                 max = Math.max(mat[0][i], max);
    //             }
    //         }
    //         return max;
    //     }
        
    //     if (dp[idx][lastTask] != -1) return dp[idx][lastTask]; 
    //     int max = 0;
    //     for (int i = 0; i <= 2; i++) {
    //         if (i != lastTask) {
    //             int points = mat[idx][i] + solve (idx - 1, i, mat, dp);
    //             max = Math.max(max, points);
    //         }
    //     }
    //     return dp[idx][lastTask] = max;
    // }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna