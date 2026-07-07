class Solution {
    public ArrayList<String> binstr(int n) {
        // code here
        ArrayList<String> ans = new ArrayList<>();
        solve (new StringBuilder(), ans, n);
        return ans;
    }
    private void solve (StringBuilder sb, List<String> ans, int n) {
        if (sb.length() == n) {
            ans.add(sb.toString());
            return;
        }
        sb.append('0');
        solve (sb, ans, n);
        sb.deleteCharAt(sb.length() - 1);
        
        
        sb.append('1');
        solve(sb, ans, n);
        sb.deleteCharAt(sb.length() - 1);
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna