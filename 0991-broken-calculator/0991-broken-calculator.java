class Solution {
    public int brokenCalc(int startValue, int target) {
        int c = 0;
        while (startValue < target) {
            if(target % 2 == 0) target /= 2;
            else target += 1;
            c++;
        }
        return c + startValue - target;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna