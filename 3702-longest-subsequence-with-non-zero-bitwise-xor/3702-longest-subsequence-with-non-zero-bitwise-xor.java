class Solution {
    public int longestSubsequence(int[] nums) {
        int n = nums.length;
        int zero = 0;
        int xor = 0;
        for (int num : nums) {
            if (num == 0) zero ++;
            xor = xor ^ num;
        }
        if (zero == n) return 0;
        return (xor == 0) ? n - 1 : n;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna