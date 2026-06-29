class Solution {
    public static int gcd(int a, int b) {
        // code here
        if(b == 0) return a;
        return gcd(b, a % b);
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna