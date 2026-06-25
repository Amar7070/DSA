class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int l = 0;
        int r = 0;
        double ans = -Double.MAX_VALUE;
        double sum = 0;
        while(r < nums.length) {
            sum += nums[r];
            if(r - l + 1 == k) {
                ans = Math.max(ans, sum / k);
                sum -= nums[l];
                l++;
            }
            r++;
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna