class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];
        int p[] = new int[n];
        p[0] = 1;
        for(int i = 1; i < n; i++) {
            p[i] = p[i - 1] * nums[i - 1];
        }
        int s = 1;
        for(int i = n - 1; i >= 0; i--) {
            ans[i] = p[i] * s;
            s *= nums[i];
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna