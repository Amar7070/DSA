class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = 0;
        for(int pile : piles) {
            r = Math.max(pile, r);
        }
        while(l <= r) {
            int mid = l + (r - l) / 2;
            long total = totalHours(mid, piles);
            if(total <= h) {
                r = mid - 1;
            }
            else l = mid + 1;
        }
        return l;
    }
    private long totalHours(int speed, int[] piles) {
    long hours = 0;
    for (int pile : piles) {
        hours += (pile + speed - 1L) / speed;
    }
    return hours;
}
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna