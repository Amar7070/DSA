class Solution {
    public static void printPrimeFactorization(int n) {
        // code here
        while((n & 1) == 0) {
            System.out.print(2 + " ");
            n >>= 1;            
        }
        for (int i = 3; i <= n; i += 2) {
            while(n % i == 0) {
                System.out.print(i + " ");
                n /= i;
            }
        }
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna