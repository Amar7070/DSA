class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int n = 0;
        for (int[] trip : trips) {
            n = Math.max(n, trip[2]);
        }
        int[] diff = new int[n + 1];
        for(int trip[] : trips) {
            int val = trip[0];
            int l = trip[1];
            int r = trip[2];
            diff[l] += val;
            diff[r] -= val;
        }
        int curr = 0;
        for(int i = 0; i <= n; i++) {
            curr += diff[i];
            System.out.println(curr);
            if(curr > capacity) return false;
        }
        return true;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna