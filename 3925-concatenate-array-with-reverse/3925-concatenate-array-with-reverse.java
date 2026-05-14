class Solution {
    public int[] concatWithReverse(int[] nums) {
        int n = nums.length;
        int ans[] = new int[2 * n];
        for(int i = 0; i < n; i++) {
            ans[i] = nums[i];
            ans[2 * n - 1 - i] = nums[i];
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna