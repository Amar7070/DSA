class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int l = 0, r = 0;
        int ans = 0;
        while (r < n) {
            map.put (nums[r], map.getOrDefault(nums[r], 0) + 1);
            while (map.get(nums[r]) > k) {
                map.put (nums[l], map.get(nums[l]) - 1);
                l++;
            }
            ans = Math.max (ans, r - l + 1);
            r++;
        } 
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna