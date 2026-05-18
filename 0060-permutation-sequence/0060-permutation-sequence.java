class Solution {
    private void reverse(StringBuilder sb, int l, int r) {
        while(l < r) {
            char temp = sb.charAt(l);
            sb.setCharAt(l, sb.charAt(r));
            sb.setCharAt(r, temp);
            l++;
            r--;
        }
    }
    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++) sb.append(i);
        return solve(sb, k);
    }
    private String solve(StringBuilder sb, int k) {
        if(k == 1) return sb.toString();
        int idx = -1;
        for(int i = sb.length() - 2; i >= 0; i--) {
            int next = sb.charAt(i + 1) - '0';
            int prev = sb.charAt(i) - '0';
            if(prev < next) {
                idx = i;
                break;
            }
        }
        
        if(idx == -1) {
            reverse(sb, idx + 1, sb.length() - 1);
            return sb.toString();
        }
        int a = sb.charAt(idx) - '0';
        for(int i = sb.length() - 1; i >= 0; i--) {
            int t = sb.charAt(i) - '0';
            if(a < t) {
                char temp = sb.charAt(idx);
                sb.setCharAt(idx, sb.charAt(i));
                sb.setCharAt(i, temp);
                break;
            }
        }
        reverse(sb, idx + 1, sb.length() - 1);
        String s = solve(sb, k - 1);
        return s;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna