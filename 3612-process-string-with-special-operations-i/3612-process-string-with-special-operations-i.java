class Solution {
    public String processStr(String s) {
        StringBuilder res = new StringBuilder();
        for(char ch : s.toCharArray()) {
            if(Character.isLetter(ch)) {
                res.append(ch);
            }
            else if(res.length() > 0 && ch == '*') {
                res.deleteCharAt(res.length() - 1);
            }
            else if(ch == '#') {
                res.append(res);
            }
            else {
                res.reverse();
            }
        }
        return res.toString();
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna