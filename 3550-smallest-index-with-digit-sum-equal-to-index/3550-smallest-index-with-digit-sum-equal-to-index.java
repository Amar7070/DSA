class Solution {
    public int smallestIndex(int[] nums) {
        int n = nums.length;
        int ans = -1;
        for (int i = n - 1; i >= 0; i--) {
            int temp = nums[i];
            int sum = 0;
            while (temp > 0) {
                int l = temp % 10;
                sum += l;
                temp /= 10;
            }

            if (sum == i) ans = i;
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna