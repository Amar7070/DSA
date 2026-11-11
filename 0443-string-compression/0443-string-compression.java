class Solution {
    public int compress(char[] chars) {
        int count = 1;
        int idx = 0;
        for(int i = 1; i < chars.length; i++){
            if(chars[i] == chars[i - 1]) count++;
            else {
                chars[idx++] = chars[i - 1];
                if(count > 1) {
                    String s = String.valueOf(count);
                    for(int j = 0; j < s.length(); j++) {
                        chars[idx++] = s.charAt(j);
                    }
                    count = 1;
                }
            }
        }
        chars[idx++] = chars[chars.length - 1];
        if(count > 1) {
            String s = String.valueOf(count);
            for(int j = 0; j < s.length(); j++) {
                chars[idx++] = s.charAt(j);
            }
            count = 1;
        }
        return idx;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna