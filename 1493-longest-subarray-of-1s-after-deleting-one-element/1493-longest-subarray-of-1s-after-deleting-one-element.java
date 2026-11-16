class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int zeroCount = 0;
        int ans = 0;

        int l = 0, r = 0;

        while (r < n) {
            if (nums[r] == 0) zeroCount++;

            while (zeroCount > 1) {
                if (nums[l] == 0) zeroCount--;
                l++;
            }

            ans = Math.max (ans, r - l);
            r++;
        }

        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna