class Segment {
    int arr[];
    int tree[];
    int n;
    Segment (int arr[]) {
        n = arr.length;
        this.arr = arr;
        tree = new int[4 * n];
        constructST (0, n - 1, 0);
    }

    int getMax (int qs, int qe, int ss, int se, int si) {
        if (se < qs || ss > qe) return -1;
        if (qs <= ss && qe >= se) return tree[si];

        int mid = (ss + se) / 2;
        int left = getMax (qs, qe, ss, mid, 2 * si + 1);
        int right =  getMax (qs, qe, mid + 1, se, 2 * si + 2);

        if (left == -1) return right;
        if (right == -1) return left;

        return (arr[left] >= arr[right]) ? left : right;
    }

    int constructST (int ss, int se, int si) {
        if (ss == se) {
            tree[si] = ss;
            return ss;
        }

        int mid = (ss + se) / 2;

        int left = constructST(ss, mid, 2 * si + 1);
        int right = constructST(mid + 1, se, 2 * si + 2);

        tree[si] = (arr[left] >= arr[right]) ? left : right;
        return tree[si];
    }

    int getQuery (int qs, int qe) {
        return getMax (qs, qe, 0, n - 1, 0);
    }
}
class Solution {
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int n = heights.length;
        Segment st = new Segment (heights);
        
        int q = queries.length;
        int ans[] = new int[q];
        for (int i = 0; i < q; i++) {
            int a = Math.min(queries[i][0], queries[i][1]);
            int b = Math.max(queries[i][0], queries[i][1]);
            if (a == b) {
                ans[i] = a;
                continue;
            }

            if (heights[b] > heights[a]) {
                ans[i] = b;
                continue;
            }
            int l = b;
            int h = n - 1;
            int res = -1;
            while (l <= h) {
                int mid = l + (h - l) / 2;
                int rmq = st.getQuery (l, mid);

                if (heights[rmq] > Math.max(heights[a], heights[b])) {
                    res = rmq;
                    h = mid - 1;
                }
                else l = mid + 1;
            }
            ans[i] = res;
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna