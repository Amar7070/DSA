class Solution {
    public String rearrangeString(String s, char x, char y) {
        char[] ch = s.toCharArray();
        int l = 0;
        int r = ch.length - 1;
        while (l < r) {
            while (l < r && ch[l] != x) l++;
            while (l < r && ch[r] == x) r--;

            if (l < r) {
                char temp = ch[l];
                ch[l] = ch[r];
                ch[r] = temp;
                l++;
                r--;
            }
        }
        return String.valueOf(ch);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna