class Solution {
    private int solve(int idx, int arr[], int d, int[] dp) {
        int ans = 1;
        if(dp[idx] != -1) return dp[idx];
        for(int i = idx + 1; i < arr.length && i <= idx + d; i++) {
            if(arr[i] >= arr[idx]) break;
            ans = Math.max(ans, 1 + solve(i, arr, d, dp));
        }
        for(int i = idx - 1; i >= 0 && i >= idx - d; i--) {
            if(arr[i] >= arr[idx]) break;
            ans = Math.max(ans, 1 + solve(i, arr, d, dp));
        }
        return dp[idx] = ans;
    }
    public int maxJumps(int[] arr, int d) {
        int n = arr.length;
        int ans = 1;
        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        for(int i = 0; i < n; i++) {
            ans = Math.max(ans, solve(i, arr, d, dp));
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna