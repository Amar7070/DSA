class Solution {
    public List<List<Integer>> findDisappearedNumbers(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        if (nums[0] > lower) ans.add (new ArrayList<>(Arrays.asList(lower, Math.min (upper, nums[0] - 1))));
        for (int i = 0; i < n - 1; i++) {
            int left = nums[i];
            int right = nums[i + 1];

            int start = Math.max(lower, left + 1);
            int end = Math.min(upper, right - 1);

            if (start <= end) ans.add(new ArrayList<>(Arrays.asList(start, end)));
        }
        if (nums[n - 1] < upper) ans.add (new ArrayList<>(Arrays.asList(Math.max(lower, nums[n - 1] + 1), upper)));
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna