class Solution {
    public int minFlips(String s) {
        int n = s.length();
        int zero = 0;
        int one = 0;
        for(int i = 0; i < n; i++) {
            if(s.charAt(i) == '1') one++;
            else zero++;
        }
        if(zero == 0 || one == 1 || one == 0) return 0;
        int a = one, b = zero;
        if(one > 1) {
            a = one - 1;
            if(s.charAt(0) == '1' && s.charAt(n - 1) == '1') a -= 1;
        }
        return Math.min(a, b);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna