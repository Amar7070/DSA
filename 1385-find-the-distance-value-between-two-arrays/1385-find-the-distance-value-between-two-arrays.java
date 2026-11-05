class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int ans = 0;
        
        for (int a1 : arr1) {
            boolean flag = false;
            for (int a2 : arr2) {
                if (Math.abs (a1 - a2) <= d) {
                    flag = true;
                }
            }

            if (!flag) ans++;
        }

        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna