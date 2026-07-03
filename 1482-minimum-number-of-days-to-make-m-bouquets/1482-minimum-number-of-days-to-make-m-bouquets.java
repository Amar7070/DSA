class Solution {
    private boolean isPossible(int day, int[] arr, int m, int k) {
        int count = 0;
        int nm =  0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] <= day) {
                count++;
            }
            else {
                nm += (count / k);
                count = 0;
            }
        }
        nm += (count / k);
        return nm >= m;
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