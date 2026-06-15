class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int l = 0;
        int r = 0;
        long ans = 0;
        long sum = 0;
        while(r < n) {
            int nr = nums[r];
            sum += nr;
            map.put(nr, map.getOrDefault(nr, 0) + 1);
            while(map.get(nr) > 1 || map.size() > k) {
                sum -= nums[l];
                map.put(nums[l], map.get(nums[l]) - 1);
                if(map.get(nums[l]) == 0) map.remove(nums[l]);
                l++;
            }
            if(map.size() == k) ans = Math.max(ans, sum);
            r++;
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna