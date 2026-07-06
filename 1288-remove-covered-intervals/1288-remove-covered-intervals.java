class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            return b[1] - a[1];
            });
        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);
        int []curr = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (curr[0] <= intervals[i][0] && curr[1] >= intervals[i][1]) continue;
            else {
                res.add(intervals[i]);
                curr = intervals[i];
            }
        }
        return res.size();
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna