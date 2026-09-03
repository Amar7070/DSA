class Solution {
    public boolean uniformArray(int[] nums1) {
        int minOdd = Integer.MAX_VALUE;

        for (int num : nums1) {
            if (num % 2 == 1) minOdd = Math.min(minOdd, num);
        }

        if (minOdd == Integer.MAX_VALUE) return true;

        for (int num : nums1) {
            if (num < minOdd) return false;
        }

        return true;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna