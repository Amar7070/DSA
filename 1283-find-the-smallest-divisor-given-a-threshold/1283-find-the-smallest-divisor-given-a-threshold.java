class Solution {
    private boolean inRange(int nums[], int threshold, int mid) {
        int t = 0;
        for(int i = 0; i < nums.length; i++) {
            t += Math.ceilDiv(nums[i], mid);
            if(t > threshold) return false;
        }
        return true;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length;
        int l = 1;
        int h = 0;
        for(int i = 0; i < n; i++) h = Math.max(h, nums[i]);
        int ans = 0;
        while(l <= h) {
            int mid = l + (h - l) / 2;
            if(inRange(nums, threshold, mid)) {
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