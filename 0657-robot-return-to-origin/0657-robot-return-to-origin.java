class Solution {
    public boolean judgeCircle(String moves) {
        int horizontal = 0;
        int vertical = 0;
        for (char ch : moves.toCharArray()) {
            if (ch == 'L') horizontal++;
            else if (ch == 'R') horizontal--;
            else if (ch == 'U') vertical++;
            else vertical--;
        }
        return horizontal == 0 && vertical == 0;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna