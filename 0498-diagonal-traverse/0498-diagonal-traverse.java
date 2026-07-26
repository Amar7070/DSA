class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int ans[] = new int[m * n];

        int r = 0, c = 0;
        int dir = 1;

        for (int i = 0; i < m * n; i++) {
            ans[i] = mat[r][c];
            if (dir == 1) {
                r--;
                c++;
                if (c == m) {
                    c = m - 1;
                    r += 2;
                    dir = -1;
                }
                else if (r < 0) {
                    r = 0;
                    dir = -1;
                }
            }
            else {
                r++;
                c--;
                if (r == n) {
                    r = n - 1;
                    c += 2;
                    dir = 1;
                }
                else if (c < 0) {
                    c = 0;
                    dir = 1;
                }
            }
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna