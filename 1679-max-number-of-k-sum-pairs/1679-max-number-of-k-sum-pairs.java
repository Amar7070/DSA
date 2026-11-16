class Solution {
    public int maxOperations(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        int ans = 0;
        for (int i = 0; i < n; i++) {
            int comp = k - nums[i];
            if (map.containsKey(comp)) {
                ans++;
                map.put(comp, map.get(comp) - 1);

                if (map.get(comp) == 0) map.remove(comp);
            }

            else map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        } 

        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna