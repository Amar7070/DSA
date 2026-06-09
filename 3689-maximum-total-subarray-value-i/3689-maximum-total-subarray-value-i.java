class Solution {
    public long maxTotalValue(int[] nums, int k) {
        long max = Integer.MIN_VALUE;
        long min = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++) {
            max = Math.max(nums[i], max);
            min = Math.min(nums[i], min);
        }
        return k * (max - min);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna