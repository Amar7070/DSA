class Solution {
    static class SegmentTree {
        int n;
        int[] tree;
        SegmentTree(int n) {
            this.n = n;
            tree = new int[4 * n];
        }
        void update(int idx, int val) {
            update(1, 0, n - 1, idx, val);
        }
        private void update(int node, int l, int r, int idx, int val) {
            if (l == r) {
                tree[node] = val;
                return;
            }
            int mid = (l + r) >> 1;
            if (idx <= mid)
                update(node * 2, l, mid, idx, val);
            else
                update(node * 2 + 1, mid + 1, r, idx, val);
            tree[node] = Math.max(tree[node * 2], tree[node * 2 + 1]);
        }
        int query(int ql, int qr) {
            if (ql > qr) return 0;
            return query(1, 0, n - 1, ql, qr);
        }
        private int query(int node, int l, int r, int ql, int qr) {
            if (qr < l || r < ql) return 0;
            if (ql <= l && r <= qr) return tree[node];
            int mid = (l + r) >> 1;
            return Math.max(
                query(node * 2, l, mid, ql, qr),
                query(node * 2 + 1, mid + 1, r, ql, qr)
            );
        }
    }
    public List<Boolean> getResults(int[][] queries) {
        TreeSet<Integer> obstacles = new TreeSet<>();
        obstacles.add(0);
        List<Integer> coords = new ArrayList<>();
        coords.add(0);
        for (int[] q : queries) {
            if (q[0] == 1) {
                obstacles.add(q[1]);
                coords.add(q[1]);
            }
        }
        Collections.sort(coords);
        int m = coords.size();
        Map<Integer, Integer> index = new HashMap<>();
        for (int i = 0; i < m; i++) {
            index.put(coords.get(i), i);
        }
        SegmentTree seg = new SegmentTree(m);
        int prev = coords.get(0);
        seg.update(index.get(prev), 0);
        for (int i = 1; i < m; i++) {
            int cur = coords.get(i);
            seg.update(index.get(cur), cur - prev);
            prev = cur;
        }
        List<Boolean> ans = new ArrayList<>();
        for (int i = queries.length - 1; i >= 0; i--) {
            int[] q = queries[i];
            if (q[0] == 1) {
                int x = q[1];
                Integer left = obstacles.lower(x);
                Integer right = obstacles.higher(x);
                if (right != null) {
                    seg.update(index.get(right), right - left);
                }
                seg.update(index.get(x), 0);
                obstacles.remove(x);
            } else {
                int x = q[1];
                int sz = q[2];
                Integer pred = obstacles.floor(x);
                int maxGap = seg.query(0, index.get(pred));
                int trailingGap = x - pred;
                ans.add(Math.max(maxGap, trailingGap) >= sz);
            }
        }
        Collections.reverse(ans);
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna