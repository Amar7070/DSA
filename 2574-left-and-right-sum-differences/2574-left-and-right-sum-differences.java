class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];
        int s = 0;
        for(int i = n - 1; i >= 1; i--) {
            s += nums[i];
        }
        System.out.println(s);
        int p = 0;
        for(int i = 0; i < n; i++) {
            ans[i] = Math.abs(s - p);
            p += nums[i];
            if(i + 1 < n) s -= nums[i + 1];
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna