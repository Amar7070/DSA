class Solution {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;

        int ans = 0; 

        while (l < r) {
            int i = height[l];
            int j = height[r];

            int currArea = Math.min(i, j) * (r - l);

            if (i < j) {
                while (l < r && height[l] <= i) l++; 
            }
            else {
                while (l < r && height[r] <= j) r--;
            }

            ans = Math.max (ans, currArea);
        }

        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna