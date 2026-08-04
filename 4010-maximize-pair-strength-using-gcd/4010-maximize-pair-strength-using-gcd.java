class Solution {
    private int gcd (int a, int b) {
        if(b == 0) return a;
        return gcd (b, a % b);
    }

    public long maxPairStrength(int[] nums) {
        int n = nums.length;
        long ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int g = gcd (nums[i], nums[j]); 
                long temp = (1L * nums[i] * nums[j]) / (g * g);
                ans = Math.max (ans, temp);
            }
        }

        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna