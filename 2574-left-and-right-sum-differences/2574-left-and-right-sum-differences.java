class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];
        int s[] = new int[n];
        s[n - 1] = 0;
        for(int i = n - 2; i >= 0; i--) {
            s[i] = s[i + 1] + nums[i + 1];
        }
        int p = 0;
        for(int i = 0; i < n; i++) {
            ans[i] = Math.abs(s[i] - p);
            p += nums[i];
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna