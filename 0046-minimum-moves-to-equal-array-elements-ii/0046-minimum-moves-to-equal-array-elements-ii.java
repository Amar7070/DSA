class Solution {
    public int minMoves2(int[] nums) {
        int n = nums.length;
        Arrays.sort (nums);

        int med = nums[n / 2];

        int ans = 0;

        for (int num : nums) {
            ans += Math.abs (med - num);
        }

        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna