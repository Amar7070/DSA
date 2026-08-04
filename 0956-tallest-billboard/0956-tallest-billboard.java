class Solution {
    private int solve (int i, int diff, int[] rods, int memo[][]) {
        if (i >= rods.length) {
            if (diff == 0) return 0;
            return Integer.MIN_VALUE;
        }
        if(memo[i][diff + 5000] != -1) return memo[i][diff + 5000];

        int notPick = solve (i + 1, diff, rods, memo);
        int pickInL1 = rods[i] + solve (i + 1, diff + rods[i], rods, memo);
        int pickInL2 = rods[i] + solve (i + 1, diff - rods[i], rods, memo);

        return memo[i][diff + 5000] = Math.max (notPick, Math.max(pickInL1, pickInL2));
    }
    public int tallestBillboard(int[] rods) {
        int memo[][] = new int[21][10001];
        for (int i = 0; i < 21; i++) {
                Arrays.fill(memo[i], -1);
            }
        return solve (0, 0, rods, memo) / 2;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna