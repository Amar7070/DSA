class Solution {
    public int maxLength(int[] nums) {
        int n = nums.length;
        int ans = 2;
        int l = 0, r = 0;
        int prod = 1;

        while (r < n) {
            int curr = nums[r];

            while (gcd (prod, curr) > 1) {
                prod /= nums[l];
                l++;
            }

            prod *= curr;
            ans = Math.max(ans, r - l + 1);
            r++;
        }
        
        return ans;
    }

    private int gcd (int a, int b) {
        if (b == 0) return a;
        return gcd (b, a % b);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna