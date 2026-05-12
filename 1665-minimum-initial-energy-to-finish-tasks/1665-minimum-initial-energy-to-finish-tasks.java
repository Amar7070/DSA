class Solution {
    private boolean canFinish(int[][] tasks, int mid) {
        int n = tasks.length;
        for(int i = 0; i < n; i++) {
            if(mid < tasks[i][1]) return false;
            mid -= tasks[i][0];
        }
        return true;
    }
    public int minimumEffort(int[][] tasks) {
        int n = tasks.length;
        Arrays.sort(tasks, (a, b) -> (b[1] - b[0]) - (a[1] - a[0]));
        int l = 1;
        int h = 0;
        for(int i = 0; i < n; i++) {
            l = Math.max(l, tasks[i][1]);
            h += tasks[i][1];
        }
        int ans = 0;
        while(l <= h) {
            int mid = l + (h - l) / 2;
            if(canFinish(tasks, mid)) {
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
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna