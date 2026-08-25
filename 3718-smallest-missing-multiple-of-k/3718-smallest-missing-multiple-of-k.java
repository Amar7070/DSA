class Solution {
    public int missingMultiple(int[] nums, int k) {
        boolean haveMultiple[] = new boolean[101];
        for (int num : nums) haveMultiple[num] = true;
        int i = 1;
        int mul = k;
        while (mul <= 100 && haveMultiple[mul]) {
            mul = k * i;
            i++; 
        } 
        return mul;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna