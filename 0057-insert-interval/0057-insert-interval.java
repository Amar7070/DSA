class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        int temp[][] = new int[n + 1][2];
        for (int i = 0; i < n; i++) {
            temp[i] = intervals[i];
        }
        temp[n] = newInterval;
        Arrays.sort(temp, (a, b) -> a[0] - b[0]);
        int curr[] = temp[0];
        List<int[]> res = new ArrayList<>();
        for (int  i = 1; i <= n; i++) {
            if(curr[1] >= temp[i][0]) {
                curr[1] = Math.max(curr[1], temp[i][1]);
            }
            else {
                res.add(curr);
                curr = temp[i];
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