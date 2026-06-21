class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int diff[] = new int[n];
        for(int book[] : bookings) {
            int l = book[0] - 1;
            int r = book[1] - 1;
            int seat = book[2];
            diff[l] += seat;
            if(r + 1 < n) diff[r + 1] -= seat;
        }
        for(int i = 1; i < n ; i++) {
            diff[i] += diff[i - 1];
        }
        return diff;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna