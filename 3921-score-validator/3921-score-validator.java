class Solution {
    public int[] scoreValidator(String[] events) {
        int n = events.length;
        int score = 0;
        int counter = 0;
        for(int i = 0; i < n; i++) {
            if(Character.isDigit(events[i].charAt(0))) {
                score += events[i].charAt(0) - '0';
            }
            else if(events[i].equals("W")) {
                counter++;
            }
            else {
                score++;
            }
            if(counter == 10) break;
        }
        return new int[] {score, counter};
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna