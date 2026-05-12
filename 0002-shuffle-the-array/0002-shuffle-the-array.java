class Solution {
    public int[] shuffle(int[] nums, int n) {
        int ans[] = new int[2 * n];
        int i = 0, j = n;
        for(int k = 0; k < 2 * n; k++) {
            if(k % 2 == 0) ans[k] = nums[i++];
            else ans[k] = nums[j++];
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna