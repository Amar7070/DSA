class Solution {
    public int minMoves(int[] nums, int limit) {
        int n = nums.length;
        int diff[] = new int[2 * limit + 2];
        diff[2] = n;
        for(int i = 0; i < n / 2; i++) {
            int a = nums[i];
            int b = nums[n - 1 - i];
            int min = Math.min(a, b) + 1;
            int max = Math.max(a, b) + limit;
            diff[min] -= 1;
            diff[max + 1] += 1;
            diff[a + b] -= 1;
            diff[a + b + 1] += 1;
        }
        int ans = Integer.MAX_VALUE;
        for(int i = 2; i < diff.length; i++) {
            diff[i] += diff[i - 1];
            ans = Math.min(ans, diff[i]);
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna