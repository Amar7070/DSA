class Node {
    int prefix;
    int suffix;
    int best;
    char first;
    char last;

    Node(int prefix, int suffix, int best, char first, char last) {
        this.prefix = prefix;
        this.suffix = suffix;
        this.best = best;
        this.first = first;
        this.last = last;
    }
}

class Segment {
    Node[] tree;
    char[] arr;

    Segment(String s) {
        arr = s.toCharArray();
        int n = arr.length;

        tree = new Node[4 * n];
        build(0, n - 1, 0);
    }

    void build(int ss, int se, int si) {
        if (ss == se) {
            tree[si] = new Node(1, 1, 1, arr[ss], arr[ss]);
            return;
        }

        int mid = (ss + se) / 2;

        build(ss, mid, 2 * si + 1);
        build(mid + 1, se, 2 * si + 2);

        tree[si] = merge(tree[2 * si + 1], tree[2 * si + 2], mid - ss + 1, se - mid);
    }

    Node merge(Node left, Node right, int leftLen, int rightLen) {
        int best = Math.max(left.best, right.best);
        int prefix = left.prefix;
        int suffix = right.suffix;

        if (left.last == right.first) {
            best = Math.max(best, left.suffix + right.prefix);
            if (left.prefix == leftLen) {
                prefix = left.prefix + right.prefix;
            }
            if (right.suffix == rightLen) {
                suffix = left.suffix + right.suffix;
            }
        }
        return new Node(prefix, suffix, best, left.first, right.last);
    }

    void update(int ss, int se, int si, int i, char ch) {
        if (ss == se) {
            tree[si] = new Node(1, 1, 1, ch, ch);
            return;
        }

        int mid = (ss + se) / 2;
        if (i <= mid) update(ss, mid, 2 * si + 1, i, ch);
        else update(mid + 1, se, 2 * si + 2, i, ch);
        
        tree[si] = merge(tree[2 * si + 1], tree[2 * si + 2], mid - ss + 1, se - mid);
    }

    int getQuery() {
        return tree[0].best;
    }
}

class Solution {
    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        Segment st = new Segment(s);
        int q = queryIndices.length;
        int[] ans = new int[q];
        for (int i = 0; i < q; i++) {
            st.update(0, s.length() - 1, 0, queryIndices[i], queryCharacters.charAt(i));
            ans[i] = st.getQuery();
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna