class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        boolean avail[] = new boolean[101];
        List<Integer> ans = new ArrayList<>();
        int min = 101;
        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            int t = nums[i];
            avail[t] = true;
            min = Math.min(min, t);
            max = Math.max(max, t);
        }

        for (int i = min; i <= max; i++) {
            if (!avail[i]) ans.add(i);
        }

        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna