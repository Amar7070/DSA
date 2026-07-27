class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        List<Integer> less = new ArrayList<>();
        List<Integer> more = new ArrayList<>();
        int freq = 0;
        for (int num : nums) {
            if (num < pivot) {
                less.add(num);
            }
            else if (num > pivot) more.add(num);
            else {
                freq++;
            }
        }
        int ans[] = new int[n];
        int idx = 0;
        for (int num : less) {
            ans[idx++] = num;
        }
        while (freq-- > 0) ans[idx++] = pivot;
        for (int num : more) {
            ans[idx++] = num;
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna