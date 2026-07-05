class Solution {
    private int findMaxIndex (int[][] grid, int col) {
        int max = grid[0][col];
        int maxIdx = 0;
        for (int i = 0; i < grid.length; i++) {
            if (max < grid[i][col]) {
                max = grid[i][col];
                maxIdx = i;
            }
        }
        return maxIdx;

    }
    public int[] findPeakGrid (int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int l = 0, h = m - 1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            int maxRowIndex = findMaxIndex (grid, mid);
            int left = mid - 1 >= 0 ? grid[maxRowIndex][mid - 1] : -1;
            int right = mid + 1 < m ? grid[maxRowIndex][mid + 1] : -1;

            if (grid[maxRowIndex][mid] > left && grid[maxRowIndex][mid]> right) {
                return new int[]{maxRowIndex, mid};
            }
            else if (grid[maxRowIndex][mid] < left) {
                h = mid - 1;
            }
            else l = mid + 1;
        }
        return new int[]{-1, -1};
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna