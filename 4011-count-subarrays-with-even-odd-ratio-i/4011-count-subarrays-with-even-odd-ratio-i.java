class Node {
    int o;
    int e;
    Node (int o, int e) {
        this.o = o;
        this.e = e;
    }
}
class Segment {
    Node tree[];
    int nums[];
    int n;

    Segment (int arr[]) {
        n = arr.length;
        nums = arr;
        tree = new Node[4 * n];
        constructST (0, n - 1, 0);
    }

    void constructST (int ss, int se, int si) {
        if (ss == se) {
            int o = (nums[ss] % 2 == 0) ? 0 : 1;
            int e = (nums[ss] % 2 == 0) ? 1 : 0;
            tree[si] = new Node (o, e);
            return;
        }

        int mid = (ss + se) / 2;
        constructST (ss, mid, 2 * si + 1);
        constructST (mid + 1, se, 2 * si + 2);
        Node left = tree[2 * si + 1];
        Node right = tree[2 * si + 2];
        int o = left.o + right.o;
        int e = left.e + right.e;
        tree[si] = new Node(o, e); 
    }

    Node query (int qs, int qe, int ss, int se, int si) {
        if (qs <= ss && se <= qe) return tree[si];
        if (ss > qe || qs > se) return new Node (0, 0);

        int mid = (ss + se) / 2;

        Node left = query (qs, qe, ss, mid, 2 * si + 1);
        Node right = query (qs, qe, mid + 1, se, 2 * si + 2);

        return new Node (left.o + right.o, left.e + right.e);
    }
}
class Solution {
    public int countRatioSubarrays(int[] nums, int a, int b) {
        int n = nums.length;
        Segment st = new Segment (nums);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                Node temp = st.query(i, j, 0, n - 1, 0);
                if ((long)temp.e * b <= (long)temp.o * a) ans++;
            }
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna