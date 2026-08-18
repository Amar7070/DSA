class Solution {
    public int nearestDrone(int[][] drones, int[] t) {
        int n = drones.length;
        int dist = Integer.MAX_VALUE;
        int ans = -1;
        for (int i = n - 1; i >= 0; i--) {
            int curr = Math.abs(drones[i][0] - t[0]) + Math.abs(drones[i][1] - t[1]);
            if (curr <= drones[i][2] && dist >= curr) {
                ans = i;
                dist = curr;
            }
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna