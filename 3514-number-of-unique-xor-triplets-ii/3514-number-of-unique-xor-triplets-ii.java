class Solution {
    public int uniqueXorTriplets(int[] nums) {
        BitSet set = new BitSet();
        BitSet set1 = new BitSet();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                set.set (nums[i] ^ nums[j]);
            }
        }
        for (int i = set.nextSetBit(0); i >= 0; i = set.nextSetBit(i + 1)) {
            for (int j = 0; j < n; j++) {
                set1.set(i ^ nums[j]);
            }
        }
        return set1.cardinality();
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna