class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int curr[] = intervals[0];
        List<int[]> res = new ArrayList<>();
        for (int  i = 1; i < n; i++) {
            if(curr[1] >= intervals[i][0]) {
                curr[1] = Math.max(curr[1], intervals[i][1]);
            }
            else {
                res.add(curr);
                curr = intervals[i];
            }
        }
        res.add(curr);
        int ans[][] = new int[res.size()][2];
        int i = 0;
        for (int a[] : res) {
            ans[i++] = a;
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna