class Solution {
    public String[] createGrid(int m, int n) {
        String[] ans = new String[m];
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for(int i = 0; i < n; i++) {
            sb1.append('.');
            if(i == n - 1) {
                sb2.append('.');
                break;
            }
            sb2.append('#');
        }
        for(int i = 0; i < m; i++) {
            if(i != 0) ans[i] = sb2.toString();
            else ans[i] = sb1.toString();
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna