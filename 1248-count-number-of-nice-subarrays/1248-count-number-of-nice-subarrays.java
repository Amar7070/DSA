class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        int odd = 0;
        int l = 0, r = 0;
        int ans = 0;
        int prefix = 0;
        while(r < n) {
            if(nums[r] % 2 == 1) {
                odd += nums[r] % 2;
                prefix = 0;
            }
            
            while(odd == k) {
                prefix++;
                odd -= nums[l] % 2;
                l++;
            }
            ans += prefix;
            r++;
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna