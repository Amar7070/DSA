class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();

        int l = 0, r = 0;
        int countOne = 0;
        String ans = "";
        while (r < n) {
            char right = s.charAt(r);
            if (right == '1') countOne++;

            while (l <= r && (s.charAt(l) == '0' || countOne > k)) {
                if (s.charAt(l) == '1') countOne--;
                l++;
            }
            if (countOne == k) {
                String temp = s.substring(l, r + 1);
                if (ans.equals("") || r - l + 1 < ans.length()) {
                    ans = temp;
                }
                else if (r - l + 1 == ans.length() && ans.compareTo(temp) > 0) {
                    ans = temp;
                }
            }
            r++;
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna