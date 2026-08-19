class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        int m = reservedSeats.length;
        Arrays.sort (reservedSeats, (a, b) -> a[0] - b[0]);
        int distinctRow = 0;
        int ans = 0;
        for (int i = 0; i < m; ) {
            int row = reservedSeats[i][0];
            boolean[] space = new boolean[3];
            distinctRow++;
            while (i < m && reservedSeats[i][0] == row) {
                int col = reservedSeats[i][1];
                if (col == 2 || col == 3) space[0] = true;
                if (col == 4 || col == 5) {
                    space[0] = true;
                    space[1] = true;
                }
                if (col == 6 || col == 7) {
                    space[1] = true;
                    space[2] = true;
                }
                if (col == 8 || col == 9) space[2] = true;
                i++;
            }
            if (!space[0] && !space[2]) ans += 2;
            else if (!space[0] || !space[1] || !space[2]) ans += 1;
        }
        ans += (n - distinctRow) * 2;
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna