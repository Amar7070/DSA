class Solution {
    private int gcd (int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
    public long gcdSum(int[] nums) {
        int n = nums.length;
        int max = 0;
        int prefixGcd[] = new int[n];
        for (int i = 0; i < n; i++) {
            if (nums[i] > max) {
                max = nums[i];
                prefixGcd[i] = nums[i];
            } 
            else {
                prefixGcd[i] = gcd(nums[i], max);
            }
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