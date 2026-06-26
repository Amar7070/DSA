/* The functions which
builds the segment tree */
class GfG {
    static int st[];
    private static void build(int st[], int arr[], int si, int ss, int se) {
        if(se == ss) {
            st[si] = arr[ss];
            return;
        }
        int mid = (ss + se) / 2;
        
        build(st, arr, 2 * si + 1, ss, mid);
        build(st, arr, 2 * si + 2, mid + 1, se);
        
        st[si] = Math.min(st[2 * si + 1], st[2 * si + 2]);
        
    }
    public static int[] constructST(int arr[], int n) {
        // Add your code here
        st = new int[4 * n];
        build(st, arr, 0, 0, n - 1);
        return st;
    }

    /* The functions returns the
      min element in the range
      from l and r */
    private static int query(int st[], int si, int ss, int se, int qs, int qe) {
        if(qs > se || qe < ss) return Integer.MAX_VALUE;
        if(qs <= ss && qe >= se) return st[si];
        int mid = (ss + se) / 2;
        return Math.min(query(st, 2 * si + 1, ss, mid, qs, qe), query(st, 2 * si + 2, mid + 1, se, qs, qe));
    }
    public static int RMQ(int st[], int n, int l, int r) {
        // Add your code here
        return query(st, 0, 0, n - 1, l, r);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna