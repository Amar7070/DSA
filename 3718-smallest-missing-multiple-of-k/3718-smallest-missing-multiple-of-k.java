class Solution {
    public int missingMultiple(int[] nums, int k) {
        boolean isMultiple[] = new boolean[101];
        for (int num : nums) isMultiple[num] = true;
        int mul;
        for (mul = k; mul <= 100; mul += k) {
            if (!isMultiple[mul]) break; 
        }
        return mul;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna