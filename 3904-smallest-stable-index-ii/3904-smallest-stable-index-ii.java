class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int max[] = new int[n];
        max[0] = nums[0];
        for(int i = 1; i < n; i++) {
            if(nums[i] > max[i - 1]) max[i] = nums[i];
            else max[i] = max[i - 1];
        }
        int min[] = new int[n];
        min[n - 1] = nums[n - 1];
        for(int i = n - 2; i >=0; i--) {
            if(nums[i] < min[i + 1]) min[i] = nums[i];
            else min[i] = min[i + 1];
        }
        int ans = -1;
        for(int i = 0; i < n; i++) {
            int temp = max[i] - min[i];
            if(temp <= k) {
                ans = i;
                break;
            }
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna