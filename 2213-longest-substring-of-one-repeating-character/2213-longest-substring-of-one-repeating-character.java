class Node {
    int prefix;
    int suffix;
    int best;
    char first;
    char last;
    Node (int prefix, int suffix, int best, char first, char last) {
        this.prefix = prefix;
        this.suffix = suffix;
        this.best = best;
        this.first = first;
        this.last = last;
    }
}
class Segment {
    Node tree[];
    char[] arr;
    Segment (String s){
        arr = s.toCharArray();
        int n = arr.length;
        tree = new Node[4 * n];
        constructST(0, n - 1, 0);
    }

    void constructST ( int ss, int se, int si) {
        if (ss == se) {
            tree[si] = new Node (1, 1, 1, arr[ss], arr[ss]);
            return;
        }

        int mid = (ss + se) / 2;
        constructST (ss, mid, 2 * si + 1);
        constructST (mid + 1, se, 2 * si + 2);
        Node left = tree[2 * si + 1];
        Node right = tree[2 * si + 2];
        int leftLen = mid - ss + 1;
        int rightLen = se - mid;
        int best = Math.max(left.best, right.best);
        char first = left.first;
        char last = right.last;
        int prefix, suffix;
        if (left.last == right.first) {
            best = Math.max(best, left.suffix + right.prefix);
        }
        if (left.last == right.first && left.prefix == leftLen) {
            prefix = left.prefix + right.prefix;
        }
        else {
            prefix = left.prefix;
        }
        if (left.last == right.first && right.suffix == rightLen) {
            suffix = left.suffix + right.suffix;
        }
        else {
            suffix = right.suffix;
        }
        tree[si] = new Node(prefix, suffix, best, first, last);
    }

    int getQuery () {
        return tree[0].best;
    }

    void update (int ss, int se, int si, int i, char ch) {
        if (i < ss || i > se) return;
        if (ss == se && ss == i) {
            tree[si] = new Node (1, 1, 1, ch, ch);
            return;
        }
        if (se > ss) {
            int mid = (ss + se) / 2;
            update (ss, mid, 2 * si + 1, i, ch);
            update (mid + 1, se, 2 * si + 2, i, ch);
            Node left = tree[2 * si + 1];
            Node right = tree[2 * si + 2];
            int leftLen = mid - ss + 1;
            int rightLen = se - mid;
            int best = Math.max(left.best, right.best);
            char first = left.first;
            char last = right.last;
            int prefix, suffix;
            if (left.last == right.first) {
                best = Math.max(best, left.suffix + right.prefix);
            }
            if (left.last == right.first && left.prefix == leftLen) {
                prefix = left.prefix + right.prefix;
            }
            else {
                prefix = left.prefix;
            }
            if (left.last == right.first && right.suffix == rightLen) {
                suffix = left.suffix + right.suffix;
            }
            else {
                suffix = right.suffix;
            }
            tree[si] = new Node(prefix, suffix, best, first, last);
        }
    }

}
class Solution {
    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        Segment st = new Segment (s);
        int k = queryIndices.length;
        int ans[] = new int[k];
        for (int i = 0; i < k; i++) {
            st.update (0, s.length() - 1, 0, queryIndices[i], queryCharacters.charAt(i));
            ans[i] = st.getQuery();
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna