class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        int satisfied = 0;
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) satisfied += customers[i];
        }

        int extra = 0;
        for (int i = 0; i < minutes; i++) {
            if (grumpy[i] == 1) extra += customers[i];
        }

        int max = extra;
        for (int i = minutes; i < n; i++) {
            // Remove the leftmost element
            if (grumpy[i - minutes] == 1) {
                extra -= customers[i - minutes];
            }

            // Add the new rightmost element
            if (grumpy[i] == 1) {
                extra += customers[i];
            }

            max = Math.max(max, extra);
        } 
        return satisfied + max;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna