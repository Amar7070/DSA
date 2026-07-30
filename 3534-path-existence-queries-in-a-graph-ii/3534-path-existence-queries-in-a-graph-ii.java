class Solution {
    int log;
    int[][] up;
    private int customUpperBound (int[][] temp, int target) {
        int l = 0;
        int h = temp.length - 1;
        int ans = 0;
        while (l <= h) {
            int mid = l + ((h - l) >> 1);
            if (temp[mid][1] <= target) {
                ans = mid;
                l = mid + 1;
            }
            else {
                h = mid - 1;
            }
        }
        return ans;
    }
    public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int temp[][] = new int[n][2];
        for (int i = 0; i < n; i++) {
            temp[i] = new int[]{i, nums[i]};
        }

        Arrays.sort(temp, (a, b) -> a[1] - b[1]);

        int nodeToIdx[] = new int[n];
        for (int i = 0; i < n; i++) {
            nodeToIdx[temp[i][0]] = i;
        }

        while ((1 << log) <= n) log++;

        up = new int[n][log + 1];

        for (int node = 0; node < n; node++) {
            int farthestIdxInOneJump = customUpperBound (temp, temp[node][1] + maxDiff);
            up[node][0] = farthestIdxInOneJump;
        }

        for (int j = 1; j <= log; j++) {
            for (int node = 0; node < n; node ++) {
                up[node][j] = up[up[node][j - 1]][j - 1];
            }
        }

        int q = queries.length;
        int ans[] = new int[q];

        for (int i = 0; i < q; i++) {
            int u = queries[i][0];
            int v = queries[i][1];

            int a = nodeToIdx[u];
            int b = nodeToIdx[v];
            if (a == b) {
                ans[i] = 0;
                continue;
            }

            if (a > b) {
                a = a ^ b;
                b = a ^ b;
                a = a ^ b;
            }

            int curr = a;
            int jump = 0;

            for (int j = log; j >= 0; j--) {
                if (up[curr][j] < b) {
                    curr = up[curr][j];
                    jump += (1 << j);
                }
            }

            if (up[curr][0] >= b) {
                ans[i] = jump + 1;
            }
            else ans[i] = -1;
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna