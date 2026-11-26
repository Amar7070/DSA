class Solution {
    public boolean canAliceWin(int n) {
        boolean alice = false;

        for (int i = 10; i > 0; i--) {
            if (i > n) return alice;
            n -= i;
            alice = !alice;
        }

        return alice;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna