class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        int n = asteroids.length;
        Arrays.sort(asteroids);
        for(int i = 0; i < n; i++){
            if(mass >= asteroids[n-1]) return true;
            if(mass < asteroids[i]) return false;
            mass += asteroids[i];
        }
        return true;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna