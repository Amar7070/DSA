class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        if(n < t.length()) return "";
        int freq[] = new int[128];
        for(char ch : t.toCharArray()) {
            freq[ch]++;
        }
        int count = t.length();
        int l = 0, r = 0;
        int start = 0;
        int minL = Integer.MAX_VALUE;
        while(r < n) {
            int right = s.charAt(r);
            if(freq[right] > 0) {
                count--;
            }
            freq[right]--;
            while(count == 0) {
                if(r - l < minL) {
                    minL = r - l;
                    start = l;
                }
                int left = s.charAt(l);
                freq[left]++;
                if(freq[left] > 0) {
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