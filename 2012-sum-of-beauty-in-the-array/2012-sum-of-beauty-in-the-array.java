class Solution {
    public int sumOfBeauties(int[] nums) {
        int n = nums.length;
        int suffix[] = new int[n];

        suffix[n - 1] = nums[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = Math.min (suffix[i + 1], nums[i]);
        }

        int ans = 0;
        int prefix = nums[0]; 
        for (int i = 1; i <= n - 2; i++) {
            if (prefix < nums[i] && suffix[i + 1] > nums[i]) {
                ans += 2;
            }
            else if (nums[i - 1] < nums[i] && nums[i] < nums[i + 1]) {
                ans++;
            }
            prefix = Math.max (prefix, nums[i]);
        }

        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna