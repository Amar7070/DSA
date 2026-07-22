class Segment {
    int[] arr;
    int tree[];
    int n;

    Segment (int arr[]) {
        n = arr.length;
        this.arr = arr;
        tree = new int[4 * n];
        constructST (0, n - 1, 0);
    }
    
    int constructST (int ss, int se, int si) {
        if (ss == se) {
            tree[si] = arr[ss];
            return arr[ss];
        }

        int mid = (ss + se) / 2;

        tree[si] = Math.max (constructST (ss, mid, 2 * si + 1), constructST (mid + 1, se, 2 * si + 2));

        return tree[si];
    }

    int getQuery (int qs, int qe, int ss, int se, int si) {
        if (se < qs || ss > qe) return Integer.MIN_VALUE;
        if (qs <= ss && qe >= se) return tree[si];

        int mid = (ss + se) / 2;

        return Math.max (getQuery (qs, qe, ss, mid, 2 * si + 1), getQuery (qs, qe, mid + 1, se, 2 * si + 2));
    }

    int rmq (int qs, int qe) {
        return getQuery (qs, qe, 0, n - 1, 0);
    }
}
class Solution {
    public List<Integer> maxActiveSectionsAfterTrade(String s, int[][] queries) {
        int n = s.length();
        List<Integer> ans = new ArrayList<>();
        List<Integer> blockStart = new ArrayList<>();
        List<Integer> blockEnd = new ArrayList<>();
        List<Integer> blockSize = new ArrayList<>();
        int oneCount = 0;
        int zero = 0;

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '1') {
                oneCount++;
                if (zero != 0) {
                    blockEnd.add(i - 1);
                    blockSize.add(zero);
                }
                zero = 0;
            }
            else {
                if (zero == 0) blockStart.add(i);
                zero++;
            }
        }

        if (zero != 0) {
            blockEnd.add(n - 1);
            blockSize.add(zero);
        }

        int m = blockStart.size(); 
        if (m < 2) {
            for (int q[] : queries) {
                ans.add(oneCount);
            }
            return ans;
        }
        
        int pairSum[] = new int[m - 1];
        for (int i = 0; i < m - 1; i++) {
            pairSum[i] = blockSize.get(i) + blockSize.get(i + 1);
        }

        Segment st = new Segment (pairSum);

        for (int q[] : queries) {
            int l = q[0];
            int r = q[1];

            int low = lowerBound (blockEnd, l);
            int high = upperBound (blockStart, r) - 1;

            int maxPairSum = 0;
            if (low < high) {
                int firstLen = blockEnd.get(low) - Math.max(blockStart.get(low), l) + 1;
                int lastLen = Math.min(blockEnd.get(high), r) - blockStart.get(high) + 1;

                if (high - low == 1) {
                    maxPairSum = firstLen + lastLen;
                }
                else {
                    int pair1 = firstLen + blockSize.get (low + 1);
                    int pair2 = blockSize.get (high - 1) + lastLen;
                    int segMax = st.rmq (low + 1, high - 2);

                    maxPairSum = Math.max (pair1, Math.max (pair2, segMax));
                }
            }
            ans.add (maxPairSum + oneCount);
        }
        return ans;
    }

    private int lowerBound (List<Integer> arr, int t) {
        int l = 0;
        int h = arr.size() - 1;
        int ans = h + 1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (arr.get(mid) >= t) {
                ans = mid;
                h = mid - 1;
            }
            else l = mid + 1;
        }
        return ans;
    }

    private int upperBound (List<Integer> arr, int t) {
        int l = 0;
        int h = arr.size() - 1;
        int ans = h + 1;

        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (arr.get(mid) > t) {
                ans = mid;
                h = mid - 1;
            }
            else l = mid + 1;
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna