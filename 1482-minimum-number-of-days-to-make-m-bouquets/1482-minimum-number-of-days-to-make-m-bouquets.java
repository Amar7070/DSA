class Solution {
   private boolean isPossible(int day, int[] arr, int m, int k) {
        int count = 0;
        int bouquets = 0;

        for (int bloom : arr) {
            if (bloom <= day) {
                count++;
                if (count == k) {
                    bouquets++;
                    if (bouquets == m) return true;
                    count = 0;
                }
            } else {
                count = 0;
            }
        }

        return false;
    }
    
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if (1L * m * k > n) return -1;
        int h = 0, l = Integer.MAX_VALUE;
        for (int bloom : bloomDay){
            h = Math.max(h, bloom);
            l = Math.min(l, bloom);
        }
        
        int ans = 0;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (isPossible(mid, bloomDay, m, k)) {
                ans = mid;
                h = mid - 1;
            }
            else {
                l = mid + 1;
            }
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna