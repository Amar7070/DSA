class Solution {
    public int minLights(int[] lights) {
        int n = lights.length;
        int diff[] = new int[n];
        for(int i = 0; i < n; i++) {
            int v = lights[i];
            if(v > 0) {
                int l = Math.max(0, i - v);
                int r = Math.min(n - 1, i + v);
                diff[l] += 1;
                if(r + 1 < n) diff[r + 1] -= 1; 
            }
        }
        int ans = 0, curr = 0;
        int len = 0;
        for(int i = 0; i < n; i++) {
            curr += diff[i];
            if(curr <= 0) {
                len++;
            }
            else {
                ans += (len + 2) / 3;
                len = 0;
            }
        }
        ans += (len + 2) / 3;
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna