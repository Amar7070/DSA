class Solution {
    public int countRatioSubarrays(int[] nums, int a, int b) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int x = 0;
            int y = 0;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] % 2 == 0) x++; 
                else y++;
                
                if (y > 0 && (long) x * b <= (long) a * y) {
                    ans++;
                }
            }
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna