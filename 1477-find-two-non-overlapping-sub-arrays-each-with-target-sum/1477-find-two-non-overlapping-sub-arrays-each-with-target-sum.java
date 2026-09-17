class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int prefixMin[] = new int[n];
        Arrays.fill (prefixMin, Integer.MAX_VALUE);
        
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int ans = Integer.MAX_VALUE;

        int l = 0;
        for (int r = 0; r < n; r++) {

            sum += arr[r];

            while (l < r && sum > target) {
                sum -= arr[l];
                l++;
            }

            if (sum == target) {
                int len = r - l + 1;
                if (l > 0 && prefixMin[l - 1] != Integer.MAX_VALUE) {
                    ans = Math.min (ans, prefixMin[l - 1] + len);
                }
                min = Math.min(min, len);
            }

            prefixMin[r] = min;
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna