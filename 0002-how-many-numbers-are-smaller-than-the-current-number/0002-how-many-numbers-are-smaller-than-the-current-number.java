class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;
        int freq[] = new int[101];
        for(int num : nums) {
            freq[num]++;
        }
        int p[] = new int[101];
        p[0] = freq[0];
        for(int i = 1; i < 101; i++) {
            p[i] = p[i - 1] + freq[i];
        }
        int ans[] = new int[n];
        for(int i = 0; i < n; i++) {
            ans[i] = p[nums[i]] - freq[nums[i]];
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna