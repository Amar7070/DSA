class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int ans = -1;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }

        int currSum = 0;

        for (int i = 0; i < n; i++) {
            if (currSum == sum - currSum - nums[i]) return i;
            currSum += nums[i];
        }

        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna