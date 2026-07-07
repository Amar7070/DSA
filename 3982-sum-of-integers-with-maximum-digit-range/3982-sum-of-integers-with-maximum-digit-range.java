class Solution {
    public int maxDigitRange(int[] nums) {
        int n = nums.length;
        int[] range = new int[n];
        int maxDR = 0;

        for (int i = 0; i < n; i++) {
            int temp = nums[i];
            int min = 9, max = 0;

            if (temp == 0) {
                min = max = 0;
            }

            while (temp > 0) {
                int d = temp % 10;
                min = Math.min(min, d);
                max = Math.max(max, d);
                temp /= 10;
            }

            range[i] = max - min;
            maxDR = Math.max(maxDR, range[i]);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (range[i] == maxDR)
                ans += nums[i];
        }

        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna