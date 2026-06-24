class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        // HashMap<Integer, Integer> map = new HashMap<>();
        int freq[] = new int[k];
        freq[0] = 1;
        int prefixSum = 0;
        int ans = 0;
        for(int i = 0; i < n; i++) {
            prefixSum += nums[i];
            int mod = ((prefixSum % k) + k) % k;
            ans += freq[mod];
            freq[mod]++;
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna