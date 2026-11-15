class Solution {
    int mod = 1000000007;
    public int numOfSubarrays(int[] arr) {
        int n = arr.length;

        int ans = 0;

        int pre[] = new int[n];
        pre[0] = arr[0];
        for (int i = 1; i < n; i++) {
            pre[i] = pre[i - 1] + arr[i];
        }

        int odd = 0;
        int even = 0;
        for (int i = 0; i < n; i++) {
            if (pre[i] % 2 == 0) {
                ans = (ans + odd) % mod;
                even++;
            }
            else {
                ans++;
                ans =(ans + even) % mod;
                odd++;
            }
        }

        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna