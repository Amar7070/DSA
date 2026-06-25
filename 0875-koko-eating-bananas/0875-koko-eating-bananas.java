class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = 0;
        for(int pile : piles) {
            r = Math.max(pile, r);
        }
        while(l <= r) {
            int mid = l + (r - l) / 2;
            if(isPossible(mid, piles) <= h) {
                r = mid - 1;
            }
            else l = mid + 1;
        }
        return l;
    }
    private int isPossible(int max, int[] piles) {
        int hour = 0;
        for(int pile : piles) {
            hour += Math.ceil((double)pile / max);
        }
        return hour;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna