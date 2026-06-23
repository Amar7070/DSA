class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        String[] keypad = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        solve(0, digits, keypad, new StringBuilder(), ans);
        return ans;
    }
    private void solve(int idx, String digits,String[] keypad, StringBuilder sb, List<String> ans) {
        if(idx == digits.length()) {
            ans.add(sb.toString());
            return;
        } 
        int num = digits.charAt(idx) - '0';
        String str = keypad[num];
        for(int i = 0; i < str.length(); i++){
            sb.append(str.charAt(i));
            solve(idx + 1, digits, keypad, sb, ans);
            sb.deleteCharAt(sb.length() - 1);
        }
    } 
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna