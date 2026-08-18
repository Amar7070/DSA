class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;
        int freq[] = new int[51];

        for (int i = 0; i < n - k + 1; i++) {
            boolean seen[] = new boolean[51];
            for (int j = i; j < i + k; j++) {
                seen[nums[j]] = true;
            }

            for (int x = 0; x <= 50; x++) {
                if (seen[x] == true) freq[x]++;
            }
        }
        for (int i = 50; i >= 0; i--) {
            if (freq[i] == 1) return i;
        }
        return -1;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna