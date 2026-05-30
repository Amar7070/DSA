class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        if(n < t.length()) return "";
        int map[] = new int[128];
        for(char ch : t.toCharArray()) {
            map[ch]++;
        }
        int l = 0, r = 0;
        int start = 0;
        int minL = Integer.MAX_VALUE;
        int count = t.length();
        while(r < n) {
            int right = s.charAt(r);
            if(map[right] > 0) {
                count--;
            }
            map[right]--;
            while(count == 0) {
                if(r - l < minL) {
                    start = l;
                    minL = r - l;
                }
                int left = s.charAt(l);
                map[left]++;
                if(map[left] > 0) {
                    count++;
                }
                l++;
            }
            r++;
        }
        return (minL == Integer.MAX_VALUE) ? "" : s.substring(start, start + minL + 1);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna