class Solution {
    public int countGoodRotations(int[] nums) {
        int n = nums.length;
        long p[] = new long[n];

        p[0] = nums[0];

        for (int i = 1; i < n; i++) {
            p[i] = p[i - 1] + nums[i];
        }

        int ans = 0;
        for (int i = 0; i < n / 2; i++) {
            long left =  p[i + n / 2 - 1];
            long right = p[n - 1] - left;
            if (i > 0) {
                left -= p[i - 1];
                right += p[i - 1];
            }
            if (left != right) ans++;
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna