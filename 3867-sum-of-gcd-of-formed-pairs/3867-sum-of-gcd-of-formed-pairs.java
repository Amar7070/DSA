class Solution {
    private int gcd (int a, int b) {
        if (b == 0) return a;
        return gcd (b, a % b);
    }
    public long gcdSum(int[] nums) {
        int n = nums.length;
        int max = 0;
        int prefixGcd[] = new int[n];
        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
            prefixGcd[i] = gcd (nums[i], max);
        }
        Arrays.sort(prefixGcd);
        long ans = 0;
        int l = 0, r = n - 1;
        while (l < r) {
            ans += gcd (prefixGcd[l++], prefixGcd[r--]);
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna