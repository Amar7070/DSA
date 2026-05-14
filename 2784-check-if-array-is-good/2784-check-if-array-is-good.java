class Solution {
    public boolean isGood(int[] nums) {
        int n = nums.length;
        int freq[] = new int[201];
        for(int num : nums) {
            freq[num]++;
        }
        if(freq[n - 1] != 2) return false;
        for(int i = 1; i < n - 1; i++) {
            if(freq[i] != 1) return false;
        }
        return true;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna